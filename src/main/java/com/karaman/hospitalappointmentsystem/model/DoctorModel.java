package com.karaman.hospitalappointmentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="doctor")
public class DoctorModel {

    @Id
    @Column(name="tcnumber")
    private Long TCNumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="gender")
    private char gender;

    @Column(name="password")
    private String password;

    @Column(name="birthDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="appellation")
    private String appellation;

    @Column(name="policlinic_name")
    private String policlinicName;

    //doctor randevu ilişkisi
    @OneToMany(mappedBy = "doctor_id", fetch = FetchType.LAZY)
    private Set<AppointmentModel> Appointments;

    //doctor reçete ilişkisi
    @OneToMany(mappedBy = "doctor_id", fetch = FetchType.LAZY)
    private Set<PrescriptionModel> Prescriptions;

}
