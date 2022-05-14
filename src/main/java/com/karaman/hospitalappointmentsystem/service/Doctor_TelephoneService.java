package com.karaman.hospitalappointmentsystem.service;


import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.Doctor_Telephone;

import java.util.List;

public interface Doctor_TelephoneService {
    Doctor_Telephone saveDoctor_Telephone(Doctor_Telephone doctor_Telephone);
    List<Doctor_Telephone> findByDoctor_Telephone_Id(Long doctor_telephone_id);
    void removeDoctor_TelephoneBy(Long doctorId);
}
