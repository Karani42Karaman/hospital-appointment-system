package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="doctor_job_telephone")
public class Doctor_Job_Telephone implements Serializable {
    @EmbeddedId
    Doctor_Job_Telephone_Id id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctor_id")
    private DoctorModel doctor_id;
}
