package com.karaman.hospitalappointmentsystem.repository;

import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.Doctor_Mail_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Doctor_MailRepository extends JpaRepository<Doctor_Mail, Doctor_Mail_Id> {
    @Query(value = "SELECT * FROM HospitalAppointmentSystem.doctor_mail where HospitalAppointmentSystem.doctor_mail.doctor_id_tcnumber = ?", nativeQuery = true)
    List<Doctor_Mail> findDoctor_MailByDoctor_id(Long doctor_mail_id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HospitalAppointmentSystem.doctor_mail  VALUES (?);", nativeQuery = true)
    Doctor_Mail saveDoctor_Mail(Doctor_Mail Doctor_Mail);

    @Transactional
    @Modifying
    @Query(value = "delete from HospitalAppointmentSystem.doctor_mail where doctor_mail.doctor_id_tcnumber = ?", nativeQuery = true)
    void removeDoctor_MailByDoctor_id(Long doctor_mail_id);





}
