package com.karaman.hospitalappointmentsystem.model;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BlackListId implements Serializable {

    private Long doctor_id;

    private Long patient_id;

    private Long appointment_id;

}
