package com.karaman.hospitalappointmentsystem.model;

import lombok.Data;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

// Kara liste tablosu
@Data
@Entity
@Table(name="black_list")// ilişkileri kurunca hata da gidecek
public class BlackListModel implements Serializable {

    @EmbeddedId
    BlackListId id;

    //doctor karaliste  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctor_id")
    private DoctorModel doctor_id;

    //hasta karaliste  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patient_id")
    private PatientModel patient_id;

    //randevu karaliste  ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("appointment_id")
    private AppointmentModel appointment_id;


    @Column(name="description")
    private String description;

}
