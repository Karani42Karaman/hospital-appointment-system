package com.karaman.hospitalappointmentsystem.service;

import com.karaman.hospitalappointmentsystem.model.PrescriptionModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PrescriptionService {
    List<PrescriptionModel> getAllPrescription();
    PrescriptionModel savePrescription(PrescriptionModel prescriptionModel);
    PrescriptionModel getPrescriptionById(Long id);
    PrescriptionModel updatePrescription(PrescriptionModel PrescriptionModel);
    void deletePrescriptionById(Long id);

    @Modifying
    @Transactional
    List<PrescriptionModel> getPrescriptionPatientIdBy(Long patientId);
    List<PrescriptionModel> getAllByDoctor(Long DoctorId);
    List<PrescriptionModel> getAllDesc();
    void deleteByDoctor(Long doctorId);
}
