package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.PoliclicModel;
import com.karaman.hospitalappointmentsystem.repository.PoliclicRepository;
import com.karaman.hospitalappointmentsystem.service.PoliclicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliclicServiceImplt implements PoliclicService {

    @Autowired
    private PoliclicRepository policlicRepository;

    public PoliclicServiceImplt(PoliclicRepository policlicRepository) {
        this.policlicRepository = policlicRepository;
    }


    @Override
    public List<PoliclicModel> getAllPoliclic() {
        return policlicRepository.findAll();
    }

    @Override
    public PoliclicModel savePoliclic(PoliclicModel policlicModel) {
        return policlicRepository.save(policlicModel);
    }

    @Override
    public PoliclicModel getPoliclicById(Long id) {
        return policlicRepository.findById(id).get();
    }

    @Override
    public PoliclicModel updatePoliclic(PoliclicModel PoliclicModel) {
        return policlicRepository.save(PoliclicModel);
    }

    @Override
    public void deletePoliclicById(Long id) {
        policlicRepository.deleteById(id);
    }
}
