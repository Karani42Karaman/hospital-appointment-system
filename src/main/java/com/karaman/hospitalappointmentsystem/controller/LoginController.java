package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.dto.LoginDto;
import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.model.ManagerModel;
import com.karaman.hospitalappointmentsystem.model.PatientModel;
import com.karaman.hospitalappointmentsystem.service.DoctorService;
import com.karaman.hospitalappointmentsystem.service.ManagerService;
import com.karaman.hospitalappointmentsystem.service.PatientService;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String adminLogin(LoginDto loginDto, HttpSession session, HttpServletResponse response) {
        ManagerModel managerModel = managerService.getManagerModelBy(loginDto.tcNumber, loginDto.password);
        if (managerModel != null) {

            String Unv= managerModel.getAppellation()+"/"+managerModel.getName()+"/"+managerModel.getSurname();

            Cookie cookie1 = new Cookie("UserInfo", Unv);
            cookie1.setMaxAge(1 * 24 * 60 * 60); // expires in 1 days
            cookie1.setSecure(false);
            cookie1.setHttpOnly(false);
            cookie1.setPath("/");
            response.addCookie(cookie1);

            session.setAttribute("manager", managerModel);
             return "redirect:/manager/getManagerPage";
        }
        return "login/home/doctorLoginPage";
    }

    @PostMapping(value = "/doctorLogin")
    public String doctorLogin(LoginDto loginDto,  HttpServletResponse response, HttpSession session) {
        DoctorModel doctorModel = doctorService.getDoctorModelBy(loginDto.tcNumber, loginDto.password);
        if (doctorModel != null) {
            String Unv= doctorModel.getAppellation()+"/"+doctorModel.getName()+"/"+doctorModel.getSurname();

            Cookie cookie1 = new Cookie("UserInfo", Unv);
            cookie1.setSecure(false);
            cookie1.setHttpOnly(false);
            cookie1.setPath("/");
            response.addCookie(cookie1);
            session.setAttribute("doctor", doctorModel);
            return "redirect:/doctor/getDoctorPage";
        }
        return "login/home/doctorLoginPage";
    }

    @PostMapping(value = "/patientLogin")
    public String patientLogin(LoginDto loginDto, HttpServletResponse response, HttpSession session) {
        PatientModel patientModel = patientService.getPatientModelBy(loginDto.tcNumber, loginDto.password);
        if (patientModel != null) {

            String Unv=  "Sayın/"+patientModel.getName()+"/"+patientModel.getSurname();

            Cookie cookie1 = new Cookie("UserInfo", Unv);
            cookie1.setSecure(false);
            cookie1.setHttpOnly(false);
            cookie1.setPath("/");
            response.addCookie(cookie1);
            session.setAttribute("patient", patientModel);
            return "redirect:/patient/getPatientPage";
        }
        return "login/home/doctorLoginPage";
    }



    @GetMapping(value = "getAccountPage")
    public String getAccountPage(){
        return "login/home/createAccount";
    }

    @PostMapping(value = "/postPatientCreatePage")
    public  String postPatientCreatePage(@ModelAttribute("patient") PatientModel patient, Model model) {
        if(patient != null) {
            patientService.savePatient(patient);
        }
        return "login/home/patientLoginPage";
    }
}
