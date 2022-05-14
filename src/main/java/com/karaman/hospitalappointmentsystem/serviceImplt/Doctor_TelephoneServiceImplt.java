package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.Doctor_Telephone;
import com.karaman.hospitalappointmentsystem.repository.Doctor_TelephoneRepository;
import com.karaman.hospitalappointmentsystem.service.Doctor_TelephoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Doctor_TelephoneServiceImplt implements Doctor_TelephoneService {
    private Doctor_TelephoneRepository doctor_telephoneRepository;

    public Doctor_TelephoneServiceImplt(Doctor_TelephoneRepository doctor_telephoneRepository) {
        this.doctor_telephoneRepository = doctor_telephoneRepository;
    }


    @Override
    public Doctor_Telephone saveDoctor_Telephone(Doctor_Telephone doctor_Telephone) {
        return doctor_telephoneRepository.save(doctor_Telephone);
    }

    @Override
    public List<Doctor_Telephone> findByDoctor_Telephone_Id(Long doctor_telephone_id) {
        return doctor_telephoneRepository.findByDoctor_Telephone_Id(doctor_telephone_id);
    }

    @Override
    public void removeDoctor_TelephoneBy(Long doctorId) {
        doctor_telephoneRepository.removeDoctor_TelephoneBy(doctorId);
    }
}
