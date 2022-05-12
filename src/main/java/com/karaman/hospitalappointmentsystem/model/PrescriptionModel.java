package com.karaman.hospitalappointmentsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="prescription")// reçete tablosu
public class PrescriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "prescription_Id")
    private Long prescriptionID;

    @Column(name="diseaseName")
    private String diseaseName;

    @Column(name="description")
    private String description;

    @Column(name="prescription_give_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date prescriptionGiveDate;

    //reçete hasta  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientModel patient_id;

    //reçete doctor  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorModel doctor_id;






}
