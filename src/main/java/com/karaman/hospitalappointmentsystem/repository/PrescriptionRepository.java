package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.PrescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionModel, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM HospitalAppointmentSystem.prescription where patient_id = ?;", nativeQuery = true)
    List<PrescriptionModel> getPrescriptionPatientIdBy(Long patientId);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.prescription order by prescription_id desc;", nativeQuery = true)
    List<PrescriptionModel> getAllDesc();

    @Query(value = "Delete  FROM HospitalAppointmentSystem.prescription where doctor_id=?;",nativeQuery = true)
    void deleteByDoctor(Long doctorId);

    @Query(value="select*  FROM HospitalAppointmentSystem.prescription where doctor_id=?;",nativeQuery = true)
    List<PrescriptionModel> getAllByDoctor(Long DoctorId);


}
