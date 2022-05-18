package com.karaman.hospitalappointmentsystem.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Data
public class TodayDto implements Serializable {

    public TodayDto(Long tcnumber, String name, String surname, LocalDate appointmentDate, LocalTime appointmentHour,Long doctorId,Long patientId,Long appointmentId) {
        this.tcnumber = tcnumber;
        this.name = name;
        this.surname = surname;
        this.appointmentDate = appointmentDate;
        this.appointmentHour = appointmentHour;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentId = appointmentId;


    }


    @Column(name="tcnumber")
    private Long tcnumber;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name = "appointment_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(name = "appointment_hour")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime appointmentHour;

    @Column(name="doctorId")
    private Long doctorId;

    @Column(name="patientId")
    private Long patientId;

    @Column(name="appointmentId")
    private Long appointmentId;


    @Column(name="gender")
    private char gender;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="birthDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="phone")
    private Long phone;

}
