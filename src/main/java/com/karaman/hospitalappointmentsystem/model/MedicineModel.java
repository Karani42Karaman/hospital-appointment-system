package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="medicine")
public class MedicineModel {

    @EmbeddedId
    MedicineId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("prescription_id")
    private PrescriptionModel prescription_id;
}
