package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
@Data
public class MedicineId implements Serializable {
    private Long prescription_id;
    private String medicineName;

}
