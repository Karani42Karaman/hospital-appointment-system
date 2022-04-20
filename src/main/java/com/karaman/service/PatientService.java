package com.karaman.service;



import com.karaman.model.PatientModel;

import java.util.List;

public interface PatientService {

    List<PatientModel> getAllPatient();
    PatientModel savePatient(PatientModel patientModel);
    PatientModel getPatientById(Long id);
    PatientModel updatePatient(PatientModel patientModel);
    void deletePatientById(Long id);

}
