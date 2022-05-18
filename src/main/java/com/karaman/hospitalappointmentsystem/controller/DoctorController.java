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
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private static  PatientModel patientModel;
    private static  Long DoctorId;
    private static  Long AppointmentId;
    private static Long PatientId;
    private final DoctorService doctorService;
    private final Doctor_MailService doctor_mailService;
    private final Doctor_Job_TelephoneService doctor_job_telephoneService;
    private final Doctor_TelephoneService doctor_telephoneService;
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final MedicineService medicineService;
    private final PrescriptionService prescriptionService;

    @Autowired
    public DoctorController(DoctorService doctorService, Doctor_MailService doctor_mailService, Doctor_Job_TelephoneService doctor_job_telephoneService, Doctor_TelephoneService doctor_telephoneService, AppointmentService appointmentService, PatientService patientService, MedicineService medicineService, PrescriptionService prescriptionService) {
        this.doctorService = doctorService;
        this.doctor_mailService = doctor_mailService;
        this.doctor_job_telephoneService = doctor_job_telephoneService;
        this.doctor_telephoneService = doctor_telephoneService;
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.medicineService = medicineService;
        this.prescriptionService = prescriptionService;
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
        List<TodayDto> appointments = appointmentService.getAppointmentToday(LocalDateTime.now().toLocalDate().plusDays(-1), LocalDateTime.now().toLocalDate().plusDays(1), sessionDoctor.getTCNumber());
        model.addAttribute("appointments", appointments);
        return "/doctor/TodayAppointments";
    }

    @RequestMapping(value="/getPrescriptions/{doctorId}/{patientId}/{appointmentId}", method= RequestMethod.GET)
    public String getPrescriptions(@PathVariable("doctorId") Long doctorId,@PathVariable("patientId") Long patientId,@PathVariable("appointmentId") Long appointmentId, HttpServletRequest request, Model model) {
        PatientId=patientId;
        DoctorId=doctorId;
        AppointmentId=appointmentId;
        patientModel = patientService.getPatientById(patientId);
        return "/doctor/CreatePrescribe";
    }


    @PostMapping("/postPrescriptions")
    public String postPrescriptions(@ModelAttribute("prescriptionDto") PrescriptionDto prescriptionDto, HttpServletRequest request, Model model) {

        DoctorModel sessionDoctor = (DoctorModel) request.getSession().getAttribute("doctor");

        PrescriptionModel prescriptionModel = new PrescriptionModel();
        prescriptionModel.setDescription(prescriptionDto.getDescription());
        prescriptionModel.setDiseaseName(prescriptionDto.getDisease_name());
        prescriptionModel.setDoctor_id(sessionDoctor);
        prescriptionModel.setPatient_id(patientModel);
        prescriptionModel.setPrescriptionGiveDate(Date.from(Instant.now()));

        prescriptionService.savePrescription(prescriptionModel);

        Stream<PrescriptionModel> prescriptionModelStream = prescriptionService.getAllPrescription().stream().sorted();
        String [] medicines = prescriptionDto.getMedicine_name().split(",");


        for (String medicine : medicines) {
            MedicineModel medicineModel = new MedicineModel();
            MedicineId medicineId = new MedicineId();

            medicineId.setMedicineName(medicine);


        }






        return "/doctor/CreatePrescribe";
    }






}
