package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Policlic")
public class PoliclicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="policlicId")
    private Long policlicId;

    @Column(name="policlic_name")
    private String policlicName;



}
