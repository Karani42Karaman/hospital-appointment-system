package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.dto.AppointmentDto;
import com.karaman.hospitalappointmentsystem.dto.AppointmentViewDto;
import com.karaman.hospitalappointmentsystem.model.*;
import com.karaman.hospitalappointmentsystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final MedicineService medicineService;
    private final PrescriptionService prescriptionService;
    private final DoctorService doctorService;
    private final BlackListService blackListService;
    private final AppointmentService appointmentService;

    public static Long doctorTcNo;
    public static LocalDate appDate;
    public static LocalTime appHour;

    public PatientController(DoctorService doctorService, PatientService patientService, ManagerService managerService, Doctor_Job_TelephoneService doctor_job_telephoneService, Doctor_MailService mailService, Doctor_TelephoneService telephoneService, MedicineService medicineService, PrescriptionService prescriptionService, BlackListService blackListService, AppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.medicineService = medicineService;
        this.prescriptionService = prescriptionService;
        this.blackListService = blackListService;
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/getPatientPage")
    public String getPatientPage(Model model) {
        return "/patient/home/patientHome";
    }

    @GetMapping(value = "/getSelectingDepartment")
    public String getSelectingDepartment(Model model, HttpServletRequest request) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient.getName() + " " + sessionPatient.getSurname());
        Long blokCount = blackListService.getBlackListPatinetCount(sessionPatient.getTCNumber());
        model.addAttribute("blokCount", blokCount);
        return "/patient/appointment/SelectingDepartment";
    }

    @PostMapping(value = "/getSelectingDoctor")
    public String getSelectingDoctor(@ModelAttribute("appointmentDto") AppointmentDto appointmentDto, Model model, HttpServletRequest request) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient.getName() + " " + sessionPatient.getSurname());
        model.addAttribute("policlinic", appointmentDto.getPoliclinicName());

        List<DoctorModel> doctors = doctorService.getDoctorByPoliclinic(appointmentDto.getPoliclinicName());
        model.addAttribute("doctors", doctors);
        return "/patient/appointment/SelectingDoctor";
    }

    @PostMapping(value = "/getSelectingDateDay")
    public String getSelectingDateDay(@ModelAttribute("appointmentDto") AppointmentDto appointmentDto, Model model, HttpServletRequest request) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient.getName() + " " + sessionPatient.getSurname());

        DoctorModel doctor = doctorService.getDoctorById(appointmentDto.getTcnumber());
        model.addAttribute("doctor", doctor);
        doctorTcNo = appointmentDto.getTcnumber();
        ArrayList<LocalDate> dateDays = new ArrayList<LocalDate>();
        int i = 1;
        while (true) {
            if (i != 7) {
                dateDays.add(LocalDateTime.now().toLocalDate().plusDays(i));
                i++;
            } else {
                break;
            }
        }

        model.addAttribute("dateDays", dateDays);
        return "/patient/appointment/SelectingDateDay";
    }

    @GetMapping(value = "/getSelectingDateHourTime/{appointmentDate}")
    public String getSelectingDateHourTime(@PathVariable("appointmentDate") String appointmentDate, Model model, HttpServletRequest request) {

        appDate = LocalDate.parse(appointmentDate);
        model.addAttribute("appDate", appDate);

        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient.getName() + " " + sessionPatient.getSurname());

        DoctorModel doctor = doctorService.getDoctorById(doctorTcNo);
        model.addAttribute("doctor", doctor);

        //TODO: burada randevu çakışmalarını  kontrol edeğiz rahatlarsak

        List<AppointmentModel> appointments = appointmentService.findByAppId(doctorTcNo);
        model.addAttribute("appointments", appointments);

        return "/patient/appointment/SelectingDateHourTime";
    }

    @GetMapping(value = "/getRandevuForm/{appointmentHour}")
    public String getRandevuForm(@PathVariable("appointmentHour") String appointmentHour, Model model, HttpServletRequest request) {

        appHour = LocalTime.parse(appointmentHour);
        model.addAttribute("appDate", appDate);
        model.addAttribute("appHour", appHour);

        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient.getName() + " " + sessionPatient.getSurname());

        DoctorModel doctor = doctorService.getDoctorById(doctorTcNo);
        model.addAttribute("doctor", doctor);
        return "/patient/appointment/FormAppointment";
    }

    //TODO: burada randevu Tarih çakışması kontorl edilecek
    @GetMapping(value = "/getSaveAppointment")
    public String getSaveAppointment(HttpServletRequest request) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        AppointmentModel appointmentModel = new AppointmentModel();
        appointmentModel.setAppointmentDate(appDate);
        appointmentModel.setAppointmentHour(appHour);
        appointmentModel.setAppointmentCreatedDate(LocalDateTime.now());
        appointmentModel.setPatient_id(sessionPatient);

        appointmentModel.setDoctor_id(doctorService.getDoctorModelByTCNumber(doctorTcNo));
        appointmentService.saveAppointment(appointmentModel);
        return "redirect:/patient/getPatientPage";
    }

    @GetMapping(value = "/getAppointmentGt")
    public String getAppointmentGt(HttpServletRequest request, Model model) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        List<AppointmentModel> appointmentList = appointmentService.getAppointmentGt(LocalDate.now(), sessionPatient.getTCNumber());
        ArrayList<AppointmentViewDto> appdto = new ArrayList<AppointmentViewDto>();
        for (AppointmentModel appointment : appointmentList) {
            DoctorModel doctorModel = doctorService.getDoctorById(appointment.getDoctor_id().getTCNumber());
            AppointmentViewDto appointmentViewDto = new AppointmentViewDto();
            appointmentViewDto.setAppointmentDate(appointment.getAppointmentDate().toString() + " : " + appointment.getAppointmentHour().toString());
            appointmentViewDto.setIsim(doctorModel.getAppellation().toString() + "-" + doctorModel.getName().toString() + "-" + doctorModel.getSurname().toString());
            appointmentViewDto.setDepartman(doctorModel.getPoliclinicName());
            appointmentViewDto.setAppointmentId(appointment.getAppointmentId());
            appdto.add(appointmentViewDto);
        }
        model.addAttribute("appdto", appdto);
        return "/patient/appointment/FutureAppointments";
    }

    @GetMapping(value = "/getAppointmentLt")
    public String getAppointmentLt(HttpServletRequest request, Model model) {
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        List<AppointmentModel> appointmentList = appointmentService.getAppointmentLt(LocalDate.now(), sessionPatient.getTCNumber());
        ArrayList<AppointmentViewDto> appdto = new ArrayList<AppointmentViewDto>();
        for (AppointmentModel appointment : appointmentList) {
            DoctorModel doctorModel = doctorService.getDoctorById(appointment.getDoctor_id().getTCNumber());
            AppointmentViewDto appointmentViewDto = new AppointmentViewDto();
            appointmentViewDto.setAppointmentDate(appointment.getAppointmentDate().toString() + " : " + appointment.getAppointmentHour().toString());
            appointmentViewDto.setIsim(doctorModel.getAppellation().toString() + "-" + doctorModel.getName().toString() + "-" + doctorModel.getSurname().toString());
            appointmentViewDto.setDepartman(doctorModel.getPoliclinicName());
            appointmentViewDto.setAppointmentId(appointment.getAppointmentId());
            appdto.add(appointmentViewDto);
        }
        model.addAttribute("appdto", appdto);
        return "/patient/appointment/PastAppointments";
    }

    @GetMapping(value = "/getDeleteAppointment/{AppointmentId}")
    public String getDeleteAppointment(@PathVariable("AppointmentId") Long AppointmentId, Model model) {
        blackListService.deleteApp(AppointmentId);
        appointmentService.deleteAppointmentById(AppointmentId);
        return "redirect:/patient/getAppointmentGt";
    }

    @GetMapping(value="/getPrescribe")
    public String getPrescribe(HttpServletRequest request, Model model){
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        List<PrescriptionModel> prescriptions= prescriptionService.getPrescriptionPatientIdBy(sessionPatient.getTCNumber());
        model.addAttribute("prescriptions", prescriptions);
        return "/patient/Prescribe/prescribe";
    }

    @GetMapping(value="/getMedicine/{prescriptionId}")
    public String getMedicine(@PathVariable("prescriptionId") Long prescriptionId, Model model){
        List<MedicineModel> medicines= medicineService.getMedicinePrescriptionsId(prescriptionId);
        model.addAttribute("medicines", medicines);
        return "/patient/Prescribe/medicine";
    }


    @GetMapping(value="/getMyProfile")
    public String getAddMedicine(HttpServletRequest request, Model model){
        PatientModel sessionPatient = (PatientModel) request.getSession().getAttribute("patient");
        model.addAttribute("patient", sessionPatient);
        return "/patient/home/MyProfile";
    }


}
