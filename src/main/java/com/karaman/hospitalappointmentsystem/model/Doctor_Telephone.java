package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="doctor_telephone")
public class Doctor_Telephone {
    @EmbeddedId
    Doctor_Telephone_Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctor_id")
    private DoctorModel doctor_id;
}
