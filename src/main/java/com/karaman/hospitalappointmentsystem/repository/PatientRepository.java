package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.ManagerModel;
import com.karaman.hospitalappointmentsystem.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    @Query(value = "SELECT * FROM patient u where u.TCNumber = ? and u.password = ?;", nativeQuery = true)
    PatientModel getPatientModelBy(Long TCNumber, String password);


    @Query(value = "SELECT * FROM patient u where u.TCNumber = ?;", nativeQuery = true)
    PatientModel getPatientById(Long id);
}
