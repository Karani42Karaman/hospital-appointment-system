package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.dto.DoctorDto;
import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {
    @Query(value = "SELECT * FROM doctor u where u.TCNumber = ? and u.password = ?;", nativeQuery = true)
    DoctorModel getDoctorModelBy(Long TCNumber, String password);

    @Query(value = "SELECT * FROM doctor u where u.TCNumber = ?;", nativeQuery = true)
    DoctorModel getDoctorModelByTCNumber(Long TCNumber);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.doctor where HospitalAppointmentSystem.doctor.policlinic_name = ?;", nativeQuery = true)
    List<DoctorModel> getDoctorByPoliclinic(String policlinic);

}
