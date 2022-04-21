package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.PrescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionModel, Long> {
}
