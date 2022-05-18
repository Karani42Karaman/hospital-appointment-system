package com.karaman.hospitalappointmentsystem.dto;

import lombok.Data;

@Data
public class PrescriptionDto {

    private String description;
    private String disease_name;
    private String medicine_name;

}
