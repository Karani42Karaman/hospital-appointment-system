package com.karaman.hospitalappointmentsystem.dto;

import com.karaman.hospitalappointmentsystem.model.AppointmentModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AppointmentViewDto {
    public String isim;
    public String appointmentDate;
    public String departman;

    public Long appointmentId;
}
