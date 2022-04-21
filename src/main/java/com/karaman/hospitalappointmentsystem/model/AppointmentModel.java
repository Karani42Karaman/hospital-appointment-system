package com.karaman.hospitalappointmentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="appointment")
public class AppointmentModel {

    public AppointmentModel() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "appointment_Id")
    private Long appointmentId;

    @Column(name = "appointment_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Column(name = "appointment_hour")
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    private Date appointmentHour;
/*
    // Cardinality: 1-N
    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<AppointmentModel> pages;
*/




}


