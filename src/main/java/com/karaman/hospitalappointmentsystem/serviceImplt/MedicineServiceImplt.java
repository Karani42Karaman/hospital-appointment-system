package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.MedicineModel;
import com.karaman.hospitalappointmentsystem.repository.MedicineRepository;
import com.karaman.hospitalappointmentsystem.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImplt implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public MedicineServiceImplt(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }


    @Override
    public List<MedicineModel> getMedicinePrescriptionsId(Long prescriptionsId) {
        return medicineRepository.getMedicinePrescriptionsId(prescriptionsId);
    }
}
