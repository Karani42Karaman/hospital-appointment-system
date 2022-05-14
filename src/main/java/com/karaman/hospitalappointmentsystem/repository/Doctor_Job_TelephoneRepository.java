package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.Doctor_Job_Telephone;
import com.karaman.hospitalappointmentsystem.model.Doctor_Job_Telephone_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Doctor_Job_TelephoneRepository extends JpaRepository<Doctor_Job_Telephone, Doctor_Job_Telephone_Id> {
   @Query(value = "SELECT * FROM HospitalAppointmentSystem.doctor_job_telephone where HospitalAppointmentSystem.doctor_job_telephone.doctor_id_tcnumber = ?;", nativeQuery = true)
    List<Doctor_Job_Telephone> findByDoctor_Job_Telephone_Id(Long id);


    @Transactional
    @Modifying
    @Query(value = "delete from HospitalAppointmentSystem.doctor_job_telephone where doctor_job_telephone.doctor_id_tcnumber = ?", nativeQuery = true)
    void removeDoctor_Job_TelephoneBy(Long doctorId);
}
