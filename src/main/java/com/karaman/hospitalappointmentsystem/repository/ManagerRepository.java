package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerModel, Long> {
    @Query(value = "SELECT * FROM manager u where u.TCNumber = ? and u.password = ?;", nativeQuery = true)
    public ManagerModel getManagerModelBy(Long TCNumber, String password);
}
