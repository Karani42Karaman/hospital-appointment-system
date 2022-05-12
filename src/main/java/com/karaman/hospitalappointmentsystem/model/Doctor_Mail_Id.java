package com.karaman.hospitalappointmentsystem.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
public class Doctor_Mail_Id implements Serializable {

    private Long doctor_id;
    private String mail;
}
