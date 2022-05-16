package com.karaman.hospitalappointmentsystem.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AppointmentDto {

    private String policlinicName;
    private Long tcnumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;



}
