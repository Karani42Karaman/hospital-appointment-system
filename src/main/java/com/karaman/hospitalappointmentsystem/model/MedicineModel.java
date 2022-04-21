package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="medicine")
@IdClass(MedicineId.class)
public class MedicineModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "prescription_Id")
    private Long prescriptionID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "medicineID")
    private Long medicineID;



}
