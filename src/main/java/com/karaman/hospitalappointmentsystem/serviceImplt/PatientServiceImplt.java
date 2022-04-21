package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.PatientModel;
import com.karaman.hospitalappointmentsystem.repository.PatientRepository;
import com.karaman.hospitalappointmentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImplt implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientServiceImplt(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientModel> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public PatientModel savePatient(PatientModel patientModel) {
        return patientRepository.save(patientModel);
    }

    @Override
    public PatientModel getPatientById(Long id) {
        return patientRepository.getById(id);
    }

    @Override
    public PatientModel updatePatient(PatientModel patientModel) {
        return patientRepository.save(patientModel);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
