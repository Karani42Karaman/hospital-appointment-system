package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
}
