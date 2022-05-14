package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
@Data
public class Doctor_Job_Telephone_Id implements Serializable {
    private Long doctor_id;
    private Long internal_phone_number;
}
