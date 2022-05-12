package com.karaman.hospitalappointmentsystem.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
public class Doctor_Telephone_Id implements Serializable {
    private Long doctor_id;
    private Long telephoneNumber;
}
