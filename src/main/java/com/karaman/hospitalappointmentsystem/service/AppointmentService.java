package com.karaman.hospitalappointmentsystem.service;

import com.karaman.hospitalappointmentsystem.model.AppointmentModel;

import java.util.List;

public interface AppointmentService {

    List<AppointmentModel> getAllAppointment();
    AppointmentModel saveAppointment(AppointmentModel appointmentModel);
    AppointmentModel getAppointmentById(Long id);
    AppointmentModel updateAppointment(AppointmentModel AppointmentModel);
    void deleteAppointmentById(Long id);
}
