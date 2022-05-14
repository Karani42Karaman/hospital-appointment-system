package com.karaman.hospitalappointmentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="patient")// Hasta tablosu
public class PatientModel {

    @Id
    @Column(name="TCNumber")
    private Long TCNumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="gender")
    private char gender;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="birthDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="phone")
    private Long phone;

    //hasta randevu ilişkisi
    @OneToMany(mappedBy = "patient_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<AppointmentModel> Appointments;

    //hasta reçete ilişkisi
    @OneToMany(mappedBy = "patient_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<PrescriptionModel> Prescriptions;


}
