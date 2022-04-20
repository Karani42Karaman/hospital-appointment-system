package com.karaman.service;

import com.karaman.model.AppointmentModel;

import java.util.List;

public interface AppointmentService {

    List<AppointmentModel> getAllAppointment();
    AppointmentModel saveAppointment(AppointmentModel appointmentModel);
    AppointmentModel getAppointmentById(Long id);
    AppointmentModel updateAppointment(AppointmentModel AppointmentModel);
    void deleteAppointmentById(Long id);
}
