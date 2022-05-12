package com.karaman.hospitalappointmentsystem.service;



import com.karaman.hospitalappointmentsystem.model.PatientModel;

import java.util.List;

public interface PatientService {

    List<PatientModel> getAllPatient();
    PatientModel savePatient(PatientModel patientModel);
    PatientModel getPatientById(Long id);
    PatientModel updatePatient(PatientModel patientModel);
    void deletePatientById(Long id);
    PatientModel getPatientModelBy(Long TCNumber, String password);

}
