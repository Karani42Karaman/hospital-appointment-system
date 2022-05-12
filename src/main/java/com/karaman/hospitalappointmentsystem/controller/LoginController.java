package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.dto.LoginDto;
import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.model.ManagerModel;
import com.karaman.hospitalappointmentsystem.model.PatientModel;
import com.karaman.hospitalappointmentsystem.service.DoctorService;
import com.karaman.hospitalappointmentsystem.service.ManagerService;
import com.karaman.hospitalappointmentsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private DoctorService doctorService;
    private PatientService patientService;
    private ManagerService managerService;

    public LoginController(DoctorService doctorService, PatientService patientService, ManagerService managerService) {
    this.doctorService = doctorService;
    this.patientService = patientService;
    this.managerService = managerService;
    }

    @GetMapping(value = "/getPermission/{permissionLevel}")
    public String getPermission(@PathVariable(value = "permissionLevel") String permissionLevel, Model model) {
        switch (permissionLevel) {
            case "admin":
                return "login/home/adminLoginPage";
            case "doctor":
                return "login/home/doctorLoginPage";
            case "patient":
                return "login/home/patientLoginPage";
            default:
                return "login/home/index";
        }
    }



    @PostMapping(value = "/adminLogin")
    public String adminLogin(LoginDto loginDto, Model model) {
        ManagerModel managerModel = managerService.getManagerModelBy(loginDto.tcNumber, loginDto.password);
        if (managerModel != null) {
            return "redirect:/manager/getManagerPage";
        }
        return "login/home/doctorLoginPage";
    }

    @PostMapping(value = "/doctorLogin")
    public String doctorLogin(LoginDto loginDto, Model model) {
        DoctorModel doctorModel = doctorService.getDoctorModelBy(loginDto.tcNumber, loginDto.password);
        return "login/home/doctorLoginPage";
    }


    @PostMapping(value = "/patientLogin")
    public String patientLogin(LoginDto loginDto, Model model) {
        PatientModel patientModel = patientService.getPatientModelBy(loginDto.tcNumber, loginDto.password);
        return "login/home/doctorLoginPage";
    }



}
