package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.dto.TodayDto;
import com.karaman.hospitalappointmentsystem.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where HospitalAppointmentSystem.appointment.doctor_id = ?;", nativeQuery = true)
    List<AppointmentModel> findByAppId(Long doctorId);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where HospitalAppointmentSystem.appointment.appointment_date >= CAST(? as Date) and patient_id=?;", nativeQuery = true)
    List<AppointmentModel> getAppointmentGt(LocalDate date, Long patientId);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where HospitalAppointmentSystem.appointment.appointment_date <= CAST(? as Date) and patient_id=?;", nativeQuery = true)
    List<AppointmentModel> getAppointmentLt(LocalDate date, Long patientId);



    @Query("select new com.karaman.hospitalappointmentsystem.dto.TodayDto(p.TCNumber,p.name,p.surname,a.appointmentDate,a.appointmentHour, d.TCNumber,p.TCNumber,a.appointmentId) from AppointmentModel a,PatientModel p,DoctorModel  d where a.appointmentDate > :begindate and a.appointmentDate < :enddate and a.doctor_id.TCNumber = :doctorId and a.appointmentHour > :begintime")
    List<TodayDto> getAppointmentToday(@Param("begindate") LocalDate begindate, @Param("enddate") LocalDate enddate, @Param("doctorId") Long doctorId,@Param("begintime") LocalTime begintime);

    @Query(value = "SELECT * FROM HospitalAppointmentSystem.appointment where  HospitalAppointmentSystem.appointment.appointment_id=?;", nativeQuery = true)
    AppointmentModel getAppointmentById(Long id);

    @Query(value = "Delete  FROM HospitalAppointmentSystem.appointment where doctor_id=?;",nativeQuery = true)
    void deleteAppointmentByDoctorId(Long doctorId);

}
