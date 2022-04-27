package com.karaman.hospitalappointmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

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
}
