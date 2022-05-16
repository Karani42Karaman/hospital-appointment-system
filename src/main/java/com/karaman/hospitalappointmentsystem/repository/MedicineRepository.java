package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.MedicineId;
import com.karaman.hospitalappointmentsystem.model.MedicineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineModel, MedicineId> {

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.medicine where prescription_id_prescription_id=?;", nativeQuery = true)
    List<MedicineModel> getMedicinePrescriptionsId(Long prescriptionsId);

}
