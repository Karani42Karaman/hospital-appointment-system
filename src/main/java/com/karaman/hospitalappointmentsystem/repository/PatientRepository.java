package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
}
