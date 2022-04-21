package com.karaman.hospitalappointmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @GetMapping("/page")
    public String getDoctorPage() {
        return "login";
    }

}
