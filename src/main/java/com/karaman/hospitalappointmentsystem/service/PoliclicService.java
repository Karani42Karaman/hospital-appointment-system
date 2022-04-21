package com.karaman.hospitalappointmentsystem.service;


import com.karaman.hospitalappointmentsystem.model.PoliclicModel;

import java.util.List;

public interface PoliclicService {
    List<PoliclicModel> getAllPoliclic();
    PoliclicModel savePoliclic(PoliclicModel policlicModel);
    PoliclicModel getPoliclicById(Long id);
    PoliclicModel updatePoliclic(PoliclicModel PoliclicModel);
    void deletePoliclicById(Long id);
}
