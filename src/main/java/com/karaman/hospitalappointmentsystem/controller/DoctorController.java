package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.model.Doctor_Job_Telephone;
import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.Doctor_Telephone;
import com.karaman.hospitalappointmentsystem.service.DoctorService;
import com.karaman.hospitalappointmentsystem.service.Doctor_Job_TelephoneService;
import com.karaman.hospitalappointmentsystem.service.Doctor_MailService;
import com.karaman.hospitalappointmentsystem.service.Doctor_TelephoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final Doctor_MailService doctor_mailService;
    private final Doctor_Job_TelephoneService doctor_job_telephoneService;
    private final Doctor_TelephoneService doctor_telephoneService;

    public DoctorController(DoctorService doctorService, Doctor_MailService doctor_mailService, Doctor_Job_TelephoneService doctor_job_telephoneService, Doctor_TelephoneService doctor_telephoneService) {
        this.doctorService = doctorService;
        this.doctor_mailService = doctor_mailService;
        this.doctor_job_telephoneService = doctor_job_telephoneService;
        this.doctor_telephoneService = doctor_telephoneService;
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





}
