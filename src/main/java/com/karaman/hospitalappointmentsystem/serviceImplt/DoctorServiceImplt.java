package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.dto.DoctorDto;
import com.karaman.hospitalappointmentsystem.repository.DoctorRepository;
import com.karaman.hospitalappointmentsystem.model.DoctorModel;
import com.karaman.hospitalappointmentsystem.service.DoctorService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImplt implements DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorServiceImplt(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorModel> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorModel saveDoctor(DoctorModel doctorModel) {
        return doctorRepository.save(doctorModel);
    }

    @Override
    public DoctorModel getDoctorById(Long id) {
        return doctorRepository.getById(id);
    }

    @Override
    public DoctorModel updateDoctor(DoctorModel doctorModel) {
        return doctorRepository.save(doctorModel);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorModel getDoctorModelBy(Long TCNumber, String password) {
        return doctorRepository.getDoctorModelBy(TCNumber, password);
    }

    @Override
    public DoctorModel getDoctorModelByTCNumber(Long TCNumber) {
        return doctorRepository.getDoctorModelByTCNumber(TCNumber);
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
