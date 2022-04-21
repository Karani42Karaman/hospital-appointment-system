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
    public List<MedicineModel> getAllMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public MedicineModel saveMedicine(MedicineModel medicineModel) {
        return medicineRepository.save(medicineModel);
    }

    @Override
    public MedicineModel getMedicineById(Long id) {
        return medicineRepository.getById(id);
    }

    @Override
    public MedicineModel updateMedicine(MedicineModel medicineModel) {
        return medicineRepository.save(medicineModel);
    }

    @Override
    public void deleteMedicineById(Long id) {
        medicineRepository.deleteById(id);
    }
}
