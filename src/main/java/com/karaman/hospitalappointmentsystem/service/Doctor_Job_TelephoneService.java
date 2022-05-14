package com.karaman.hospitalappointmentsystem.service;


import com.karaman.hospitalappointmentsystem.model.Doctor_Job_Telephone;


import java.util.List;

public interface Doctor_Job_TelephoneService {


    Doctor_Job_Telephone saveDoctor_Job_Telephone(Doctor_Job_Telephone Doctor_Job_Telephone);
    List<Doctor_Job_Telephone> findByDoctor_Job_Telephone_Id(Long id);
    void removeDoctor_Job_TelephoneBy(Long doctorId);

}
