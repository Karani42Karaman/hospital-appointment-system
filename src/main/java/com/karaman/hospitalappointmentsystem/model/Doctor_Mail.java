package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="doctor_mail")
public class Doctor_Mail implements Serializable {

    @EmbeddedId
    Doctor_Mail_Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctor_id")
    private DoctorModel doctor_id;

}
