package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.Doctor_Telephone;
import com.karaman.hospitalappointmentsystem.model.Doctor_Telephone_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Doctor_TelephoneRepository extends JpaRepository<Doctor_Telephone, Doctor_Telephone_Id> {

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.doctor_telephone where HospitalAppointmentSystem.doctor_telephone.doctor_id_tcnumber=?;", nativeQuery = true)
    List<Doctor_Telephone> findByDoctor_Telephone_Id(Long doctor_telephone_id);

    @Transactional
    @Modifying
    @Query(value = "delete from HospitalAppointmentSystem.doctor_telephone where doctor_telephone.doctor_id_tcnumber = ?", nativeQuery = true)
    void removeDoctor_TelephoneBy(Long doctorId);

}
