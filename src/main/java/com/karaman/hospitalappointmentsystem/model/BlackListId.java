package com.karaman.hospitalappointmentsystem.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BlackListId implements Serializable {

    private Long doctor_id;

    private Long patient_id;

    private Long appointment_id;

}
