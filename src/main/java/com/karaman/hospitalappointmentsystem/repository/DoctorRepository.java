package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {

    @Query(value = "SELECT * FROM doctor u where u.TCNumber = ? and u.password = ?;", nativeQuery = true)
    public DoctorModel getDoctorModelBy(Long TCNumber, String password);

}
