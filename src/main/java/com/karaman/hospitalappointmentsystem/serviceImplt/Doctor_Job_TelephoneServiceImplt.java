package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.Doctor_Job_Telephone;
import com.karaman.hospitalappointmentsystem.repository.Doctor_Job_TelephoneRepository;
import com.karaman.hospitalappointmentsystem.service.Doctor_Job_TelephoneService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Doctor_Job_TelephoneServiceImplt implements Doctor_Job_TelephoneService {

    private Doctor_Job_TelephoneRepository doctor_job_telephoneRepository;
    public Doctor_Job_TelephoneServiceImplt(Doctor_Job_TelephoneRepository doctor_job_telephoneRepository){
        this.doctor_job_telephoneRepository=doctor_job_telephoneRepository;
    }


    @Override
    public Doctor_Job_Telephone saveDoctor_Job_Telephone(Doctor_Job_Telephone Doctor_Job_Telephone) {
        return doctor_job_telephoneRepository.save(Doctor_Job_Telephone);
    }

    @Override
    public List<Doctor_Job_Telephone> findByDoctor_Job_Telephone_Id(Long doctorId) {
        return doctor_job_telephoneRepository.findByDoctor_Job_Telephone_Id(doctorId);
    }

    @Override
    public void removeDoctor_Job_TelephoneBy(Long doctorId) {
        doctor_job_telephoneRepository.removeDoctor_Job_TelephoneBy(doctorId);


    }
}
