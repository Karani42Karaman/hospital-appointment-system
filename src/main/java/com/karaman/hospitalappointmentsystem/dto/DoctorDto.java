package com.karaman.hospitalappointmentsystem.dto;


import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class DoctorDto implements Serializable {


    private Long tcNumber;


    private String name;


    private String surname;


    private char gender;


    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;


    private String appellation;


    private String policlinicName;

    private Long internal_phone_number;

    private String mail;

    private Long telephoneNumber;

}
