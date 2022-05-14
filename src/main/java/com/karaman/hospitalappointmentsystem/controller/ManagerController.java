package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.dto.DoctorDto;
import com.karaman.hospitalappointmentsystem.model.*;
import com.karaman.hospitalappointmentsystem.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final ManagerService managerService;
    private final Doctor_Job_TelephoneService doctor_job_telephoneService;
    private final Doctor_MailService mailService;
    private final Doctor_TelephoneService telephoneService;

    public ManagerController(DoctorService doctorService, PatientService patientService, ManagerService managerService, Doctor_Job_TelephoneService doctor_job_telephoneService, Doctor_MailService mailService, Doctor_TelephoneService telephoneService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.managerService = managerService;
        this.doctor_job_telephoneService = doctor_job_telephoneService;
        this.mailService = mailService;
        this.telephoneService = telephoneService;
    }


    @GetMapping(value = "/getManagerPage")
    public String getManagerPage(Model model) {
        List<DoctorModel> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors", doctors);
        return "/manager/doctor/doctorIndexPage";
    }


    @GetMapping(value = "/getDoctorUpdatePage/{doctorId}")
    public String getDoctorUpdatePage(@PathVariable("doctorId") Long doctorId, Model model) {

        DoctorModel doctor = doctorService.getDoctorModelByTCNumber(doctorId);
        List<Doctor_Mail> doctor_mail = mailService.findDoctor_MailByDoctor_id(doctorId);
        List<Doctor_Telephone> doctor_telephone = telephoneService.findByDoctor_Telephone_Id(doctorId);
        List<Doctor_Job_Telephone> doctor_job_telephone = doctor_job_telephoneService.findByDoctor_Job_Telephone_Id(doctorId);

        DoctorDto doctorDto = new DoctorDto();


        doctorDto.setMail(doctor_mail.iterator().next().getId().getMail());
        doctorDto.setTelephoneNumber(doctor_telephone.iterator().next().getId().getTelephoneNumber());
        doctorDto.setInternal_phone_number(doctor_job_telephone.iterator().next().getId().getInternal_phone_number());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setTcNumber(doctor.getTCNumber());
        doctorDto.setPassword(doctor.getPassword());
        doctorDto.setBirthDate(doctor.getBirthDate());
        doctorDto.setGender(doctor.getGender());
        doctorDto.setAppellation(doctor.getAppellation());
        doctorDto.setPoliclinicName(doctor.getPoliclinicName());

        model.addAttribute("doctorDto", doctorDto);

        return "/manager/doctor/doctorUpdatePage";
    }


    @PostMapping(value = "/postDoctorUpdatePage")
    public String postDoctorUpdatePage(@ModelAttribute("doctorDto") DoctorDto doctorDto, Model model) {

        DoctorModel doctorModel = new DoctorModel();
        doctorModel.setName(doctorDto.getName());
        doctorModel.setSurname(doctorDto.getSurname());
        doctorModel.setTCNumber(doctorDto.getTcNumber());
        doctorModel.setPassword(doctorDto.getPassword());
        doctorModel.setBirthDate(doctorDto.getBirthDate());
        doctorModel.setGender(doctorDto.getGender());
        doctorModel.setAppellation(doctorDto.getAppellation());
        doctorModel.setPoliclinicName(doctorDto.getPoliclinicName());

        doctorService.updateDoctor(doctorModel);

        // en azında kayıt etme işi böyle oluyor bunu  öğrendik
        // önce sileceksin soonra yeni kayot edeceksinm

        //mail
        Doctor_Mail doctor_mail = new Doctor_Mail();
        Doctor_Mail_Id doctor_mail_id = new Doctor_Mail_Id();

        doctor_mail_id.setMail(doctorDto.getMail());
        doctor_mail_id.setDoctor_id(doctorDto.getTcNumber());

        doctor_mail.setId(doctor_mail_id);
        doctor_mail.setDoctor_id(doctorModel);

        mailService.removeDoctor_MailByDoctor_id(doctorDto.getTcNumber());
        mailService.saveDoctor_Mail(doctor_mail);

        //telephone_job
        Doctor_Job_Telephone doctor_job_telephone = new Doctor_Job_Telephone();
        Doctor_Job_Telephone_Id doctor_job_telephone_id = new Doctor_Job_Telephone_Id();

        doctor_job_telephone_id.setInternal_phone_number(doctorDto.getInternal_phone_number());
        doctor_job_telephone_id.setDoctor_id(doctorDto.getTcNumber());

        doctor_job_telephone.setId(doctor_job_telephone_id);
        doctor_job_telephone.setDoctor_id(doctorModel);

        doctor_job_telephoneService.removeDoctor_Job_TelephoneBy(doctorDto.getTcNumber());
        doctor_job_telephoneService.saveDoctor_Job_Telephone(doctor_job_telephone);


        //telephone
        Doctor_Telephone doctor_telephone = new Doctor_Telephone();
        Doctor_Telephone_Id doctor_telephone_id = new Doctor_Telephone_Id();

        doctor_telephone_id.setTelephoneNumber(doctorDto.getTelephoneNumber());
        doctor_telephone_id.setDoctor_id(doctorDto.getTcNumber());

        doctor_telephone.setId(doctor_telephone_id);
        doctor_telephone.setDoctor_id(doctorModel);

        telephoneService.removeDoctor_TelephoneBy(doctorDto.getTcNumber());
        telephoneService.saveDoctor_Telephone(doctor_telephone);

        return "redirect:/manager/getManagerPage";
    }

}
