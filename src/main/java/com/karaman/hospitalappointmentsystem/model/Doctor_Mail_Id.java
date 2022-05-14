package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
@Data
public class Doctor_Mail_Id implements Serializable {

    private Long doctor_id;
    private String mail;
}
