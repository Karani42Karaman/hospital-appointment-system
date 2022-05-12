package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public String getDoctorPage() {
        return "doctor";
    }






}
