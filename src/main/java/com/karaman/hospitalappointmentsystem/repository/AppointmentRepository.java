package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where HospitalAppointmentSystem.appointment.doctor_id = ?;", nativeQuery = true)
    List<AppointmentModel> findByAppId(Long doctorId);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where HospitalAppointmentSystem.appointment.appointment_date >= CAST(? as Date) and patient_id=?;", nativeQuery = true)
    List<AppointmentModel> getAppointmentGt(LocalDate date, Long patientId);


}
