package com.karaman.hospitalappointmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HospitalAppointmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppointmentSystemApplication.class, args);
	}

}
