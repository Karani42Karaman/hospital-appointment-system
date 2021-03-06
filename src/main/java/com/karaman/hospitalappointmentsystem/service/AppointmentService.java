package com.karaman.hospitalappointmentsystem.service;

import com.karaman.hospitalappointmentsystem.dto.TodayDto;
import com.karaman.hospitalappointmentsystem.model.AppointmentModel;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

    List<AppointmentModel> getAllAppointment();
    AppointmentModel saveAppointment(AppointmentModel appointmentModel);
    AppointmentModel getAppointmentById(Long id);
    AppointmentModel updateAppointment(AppointmentModel AppointmentModel);
    void deleteAppointmentById(Long id);
    List<AppointmentModel> findByAppId(Long doctorId);
    List<AppointmentModel> getAppointmentGt(LocalDate date, Long patientId);
    List<AppointmentModel> getAppointmentLt(LocalDate date, Long patientId);
    List<TodayDto> getAppointmentToday(LocalDate begindate,LocalDate enddate,Long doctorId,LocalTime begintime);
    void deleteAppointmentByDoctorId(Long doctorId);

}
