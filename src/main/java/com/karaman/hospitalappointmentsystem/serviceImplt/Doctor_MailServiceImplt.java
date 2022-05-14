package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.Doctor_Mail_Id;
import com.karaman.hospitalappointmentsystem.repository.Doctor_MailRepository;
import com.karaman.hospitalappointmentsystem.service.Doctor_MailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Doctor_MailServiceImplt implements Doctor_MailService {
    private Doctor_MailRepository doctor_mailRepository;

    public Doctor_MailServiceImplt(Doctor_MailRepository doctor_mailRepository) {
        this.doctor_mailRepository = doctor_mailRepository;
    }




    @Override
    public List<Doctor_Mail> getAllDoctor_Mail() {
        return doctor_mailRepository.findAll();
    }

    @Override
    public Doctor_Mail saveDoctor_Mail(Doctor_Mail Doctor_Mail) {
        return doctor_mailRepository.save(Doctor_Mail);
    }

    @Override
    public Doctor_Mail getDoctor_MailById(Doctor_Mail_Id id) {
        return doctor_mailRepository.findById(id).orElse(null);
    }

    @Override
    public void removeDoctor_MailByDoctor_id(Long doctor_mail_id) {
        doctor_mailRepository.removeDoctor_MailByDoctor_id(doctor_mail_id);
    }

    @Override
    public List<Doctor_Mail> findDoctor_MailByDoctor_id(Long doctor_mail_id) {
        return doctor_mailRepository.findDoctor_MailByDoctor_id(doctor_mail_id);
    }
}
