package com.karaman.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="doctor")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
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

    @Column(name="jobPhoneNumber")
    private Long jobPhoneNumber;

    @Column(name="appellation")
    private String appellation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointmentFK_id", nullable = false)
    private AppointmentModel appointment;


}
