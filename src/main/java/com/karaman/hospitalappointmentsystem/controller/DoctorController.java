package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.dto.PrescriptionDto;
import com.karaman.hospitalappointmentsystem.dto.TodayDto;
import com.karaman.hospitalappointmentsystem.model.*;
import com.karaman.hospitalappointmentsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    public static PatientModel _PatientModel;
    public static Long _DoctorId;
    public static Long _AppointmentId;
    public static Long _PatientId;
    private final DoctorService doctorService;
    private final Doctor_MailService doctor_mailService;
    private final Doctor_Job_TelephoneService doctor_job_telephoneService;
    private final Doctor_TelephoneService doctor_telephoneService;
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final MedicineService medicineService;
    private final PrescriptionService prescriptionService;
    private final BlackListService blackListService;

    @Autowired
    public DoctorController(DoctorService doctorService, Doctor_MailService doctor_mailService, Doctor_Job_TelephoneService doctor_job_telephoneService, Doctor_TelephoneService doctor_telephoneService, AppointmentService appointmentService, PatientService patientService, MedicineService medicineService, PrescriptionService prescriptionService, BlackListService blackListService) {
        this.doctorService = doctorService;
        this.doctor_mailService = doctor_mailService;
        this.doctor_job_telephoneService = doctor_job_telephoneService;
        this.doctor_telephoneService = doctor_telephoneService;
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.medicineService = medicineService;
        this.prescriptionService = prescriptionService;
        this.blackListService = blackListService;
    }

    @GetMapping("/getDoctorPage")
    public String getDoctorPage() {
        return "doctor/doctorIndex";
    }

    @GetMapping("/getDoctorProfilePage")
    public String getDoctorProfilePage(HttpServletRequest request, Model model) {
        DoctorModel sessionDoctor = (DoctorModel) request.getSession().getAttribute("doctor");
        model.addAttribute("doctor", sessionDoctor);

        Long doctorId =sessionDoctor.getTCNumber();
        List<Doctor_Job_Telephone> doctor_job_telephones = doctor_job_telephoneService.findByDoctor_Job_Telephone_Id(doctorId);
        model.addAttribute("doctor_job_telephones", doctor_job_telephones);

        List<Doctor_Mail> doctor_mails = doctor_mailService.findDoctor_MailByDoctor_id(sessionDoctor.getTCNumber());
        model.addAttribute("doctor_mails", doctor_mails);

        List<Doctor_Telephone> doctor_telephones = doctor_telephoneService.findByDoctor_Telephone_Id(sessionDoctor.getTCNumber());
        model.addAttribute("doctor_telephones", doctor_telephones);
        return "/doctor/doctorMyProfile";
    }

    @GetMapping("/getTodayAppointments")
    public String getTodayAppointments(HttpServletRequest request, Model model) {
        DoctorModel sessionDoctor = (DoctorModel) request.getSession().getAttribute("doctor");
        LocalTime asda = LocalDateTime.now().toLocalTime();
        List<TodayDto> appointments = appointmentService.getAppointmentToday(LocalDateTime.now().toLocalDate().plusDays(-1), LocalDateTime.now().toLocalDate().plusDays(1), sessionDoctor.getTCNumber(), LocalDateTime.now().toLocalTime());
        model.addAttribute("appointments", appointments);
        return "/doctor/TodayAppointments";
    }

    @RequestMapping(value="/getPrescriptions/{doctorId}/{patientId}/{appointmentId}", method= RequestMethod.GET)
    public String getPrescriptions(@PathVariable("doctorId") Long doctorId,@PathVariable("patientId") Long patientId,@PathVariable("appointmentId") Long appointmentId, HttpServletRequest request, Model model) {
        _PatientId=patientId;
        _DoctorId=doctorId;
        _AppointmentId=appointmentId;
        _PatientModel = patientService.getPatientById(_PatientId);
        return "/doctor/CreatePrescribe";
    }


    @PostMapping("/postPrescriptions")
    public String postPrescriptions(@ModelAttribute("prescriptionDto") PrescriptionDto prescriptionDto, HttpServletRequest request, Model model) {

        DoctorModel sessionDoctor = (DoctorModel) request.getSession().getAttribute("doctor");

        PrescriptionModel prescriptionModel = new PrescriptionModel();
        prescriptionModel.setDescription(prescriptionDto.getDescription());
        prescriptionModel.setDiseaseName(prescriptionDto.getDisease_name());
        prescriptionModel.setDoctor_id(sessionDoctor);
        prescriptionModel.setPatient_id(_PatientModel);
        prescriptionModel.setPrescriptionGiveDate(Date.from(Instant.now()));
        prescriptionService.savePrescription(prescriptionModel);
        List<PrescriptionModel> getAlldsc = prescriptionService.getAllDesc();
        String[] medicines = prescriptionDto.getMedicine_name().split("\r\n");

        for (String medicine : medicines) {
            MedicineModel medicineModel = new MedicineModel();
            MedicineId medicineId = new MedicineId();

            medicineId.setMedicineName(medicine);
            medicineId.setPrescription_id(getAlldsc.get(0).getPrescriptionID());

            medicineModel.setId(medicineId);
            medicineModel.setPrescription_id(getAlldsc.get(0));
            medicineService.saveMedicine(medicineModel);
        }
        
        return "/doctor/CreatePrescribe";
    }


    @RequestMapping(value = "/getBlackList/{doctorId}/{patientId}/{appointmentId}", method = RequestMethod.GET)
    public String getBlackList(@PathVariable("doctorId") Long doctorId, @PathVariable("patientId") Long patientId, @PathVariable("appointmentId") Long appointmentId, HttpServletRequest request, Model model) {
        _PatientId = patientId;
        _DoctorId = doctorId;
        _AppointmentId=appointmentId;
        _PatientModel = patientService.getPatientById(patientId);
        return "/doctor/blackListPage";
    }


    @PostMapping(value = "/postBlackList")
    public String postBlackList(@ModelAttribute("blackListModel") BlackListModel blackListModel, HttpServletRequest request) {

        DoctorModel sessionDoctor = (DoctorModel) request.getSession().getAttribute("doctor");

        BlackListModel blackListModel1 = new BlackListModel();

        BlackListId blackListId = new BlackListId();
        blackListId.setPatient_id(_PatientId);
        blackListId.setDoctor_id(_DoctorId);
        blackListId.setAppointment_id(_AppointmentId);


        blackListModel1.setId(blackListId);
        blackListModel1.setDescription(blackListModel.getDescription());
        blackListModel1.setDoctor_id(sessionDoctor);
        blackListModel1.setPatient_id(_PatientModel);
        blackListModel1.setAppointment_id(appointmentService.getAppointmentById(_AppointmentId));

        blackListService.saveBlackList(blackListModel1);
        return "redirect:/doctor/getTodayAppointments";
    }

}
