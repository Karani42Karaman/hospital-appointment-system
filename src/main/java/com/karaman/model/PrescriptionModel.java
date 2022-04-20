package com.karaman.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="prescription")
public class PrescriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "prescription_Id")
    private Long prescriptionID;

    @Column(name="diseaseName")
    private String diseaseName;

    @Column(name="description")
    private String description;

}
