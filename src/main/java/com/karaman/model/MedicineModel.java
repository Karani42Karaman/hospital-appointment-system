package com.karaman.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="medicine")
public class MedicineModel {
    // bu kısım hocaya sorulacak nasıl olmalı  diye
    // kafam karıştı

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "prescription_Id")
    private Long prescriptionID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "medicineID")
    private Long medicineID;



}
