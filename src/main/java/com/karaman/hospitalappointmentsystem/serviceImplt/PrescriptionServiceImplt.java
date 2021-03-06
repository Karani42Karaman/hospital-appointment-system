package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.PrescriptionModel;
import com.karaman.hospitalappointmentsystem.repository.PrescriptionRepository;
import com.karaman.hospitalappointmentsystem.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrescriptionServiceImplt implements PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImplt(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<PrescriptionModel> getAllPrescription() {
        return prescriptionRepository.findAll();
    }

    @Override
    public PrescriptionModel savePrescription(PrescriptionModel prescriptionModel) {
        return prescriptionRepository.save(prescriptionModel);
    }

    @Override
    public PrescriptionModel getPrescriptionById(Long id) {
        return prescriptionRepository.getById(id);
    }

    @Override
    public PrescriptionModel updatePrescription(PrescriptionModel PrescriptionModel) {
        return prescriptionRepository.save(PrescriptionModel);
    }

    @Override
    public void deletePrescriptionById(Long id) {
        prescriptionRepository.deleteById(id);
    }


    @Modifying
    @Transactional
    @Override
    public List<PrescriptionModel> getPrescriptionPatientIdBy(Long patientId) {
        return prescriptionRepository.getPrescriptionPatientIdBy(patientId);
    }

    @Override
    public List<PrescriptionModel> getAllByDoctor(Long DoctorId) {
        return prescriptionRepository.getAllByDoctor(DoctorId);
    }

    @Override
    public List<PrescriptionModel> getAllDesc() {
        return prescriptionRepository.getAllDesc();
    }

    @Override
    public void deleteByDoctor(Long doctorId) {
        prescriptionRepository.deleteByDoctor(doctorId);
    }
}
