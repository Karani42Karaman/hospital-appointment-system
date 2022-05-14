package com.karaman.hospitalappointmentsystem.service;


import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.Doctor_Mail_Id;

import java.util.List;

public interface Doctor_MailService {
    List<Doctor_Mail> getAllDoctor_Mail();
    Doctor_Mail saveDoctor_Mail(Doctor_Mail Doctor_Mail);
    Doctor_Mail getDoctor_MailById(Doctor_Mail_Id id);

    void removeDoctor_MailByDoctor_id(Long doctor_mail_id);
    List<Doctor_Mail> findDoctor_MailByDoctor_id(Long doctor_mail_id);
}
