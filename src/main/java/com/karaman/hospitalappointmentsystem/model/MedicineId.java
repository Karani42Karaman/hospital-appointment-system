package com.karaman.hospitalappointmentsystem.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

//composit primary  keylerimiz
@Embeddable
public class MedicineId implements Serializable {
    private Long prescription_id;
    private String medicineName;

}
