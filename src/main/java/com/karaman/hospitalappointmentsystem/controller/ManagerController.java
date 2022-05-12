package com.karaman.hospitalappointmentsystem.controller;

import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.service.DoctorService;
import com.karaman.hospitalappointmentsystem.service.ManagerService;
import com.karaman.hospitalappointmentsystem.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="/manager")
public class ManagerController {

    private DoctorService doctorService;
    private PatientService patientService;
    private ManagerService managerService;

    public ManagerController(DoctorService doctorService, PatientService patientService, ManagerService managerService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.managerService = managerService;
    }


    @GetMapping(value ="/getManagerPage")
    public String getManagerPage(Model model) {

        List<DoctorModel> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors", doctors);

        return "manager/doctorIndexPage";
    }

}
