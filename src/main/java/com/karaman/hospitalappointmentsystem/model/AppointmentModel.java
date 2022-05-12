package com.karaman.hospitalappointmentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="appointment")//Randevu tablosu
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

    @Column(name = "appointment_created_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date appointmentCreatedDate;


    //doctor randevu  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorModel doctor_id;

    //hasta randevu  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient_id;


}


