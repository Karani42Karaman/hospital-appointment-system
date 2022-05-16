package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.BlackListModel;
import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlackListRepository extends JpaRepository<BlackListModel, Long> {

    @Query(value = "SELECT count(patient_id_tcnumber) FROM HospitalAppointmentSystem.black_list where patient_id_tcnumber = ?;", nativeQuery = true)
    Long getBlackListPatinetCount(Long patientId);

    @Query(value = "Delete from HospitalAppointmentSystem.black_list where black_list.appointment_id_appointment_id = ?", nativeQuery = true)
    void deleteByAppointId(Long appointId);
}
