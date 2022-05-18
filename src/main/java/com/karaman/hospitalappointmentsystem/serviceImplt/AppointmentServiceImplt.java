package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.dto.TodayDto;
import com.karaman.hospitalappointmentsystem.model.AppointmentModel;
import com.karaman.hospitalappointmentsystem.repository.AppointmentRepository;
import com.karaman.hospitalappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImplt implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImplt(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public List<AppointmentModel> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentModel saveAppointment(AppointmentModel appointmentModel) {
        return appointmentRepository.save(appointmentModel);
    }

    @Override
    public AppointmentModel getAppointmentById(Long id) {
        return appointmentRepository.getAppointmentById(id);
    }

    @Override
    public AppointmentModel updateAppointment(AppointmentModel AppointmentModel) {
        return appointmentRepository.save(AppointmentModel);
    }

    @Override
    public void deleteAppointmentById(Long id) {
    appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentModel> findByAppId(Long doctorId) {
        return appointmentRepository.findByAppId(doctorId);
    }

    @Override
    public List<AppointmentModel> getAppointmentGt(LocalDate date, Long patientId) {
        return appointmentRepository.getAppointmentGt(date,patientId);
    }

    @Override
    public List<AppointmentModel> getAppointmentLt(LocalDate date, Long patientId) {
        return appointmentRepository.getAppointmentLt(date,patientId);
    }

    @Override
    public List<TodayDto> getAppointmentToday(LocalDate begindate, LocalDate enddate, Long doctorId, LocalTime begintime) {
        return  appointmentRepository.getAppointmentToday(begindate,enddate,doctorId,begintime);
    }


}
