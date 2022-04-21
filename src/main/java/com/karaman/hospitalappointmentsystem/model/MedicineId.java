package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;


import java.io.Serializable;

@Data
public class MedicineId implements Serializable {

    private Long prescriptionID;
    private Long medicineID;

}
