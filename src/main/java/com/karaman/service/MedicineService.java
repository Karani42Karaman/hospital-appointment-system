package com.karaman.service;

import com.karaman.model.MedicineModel;

import java.util.List;

public interface MedicineService {

    List<MedicineModel> getAllMedicine();
    MedicineModel saveMedicine(MedicineModel medicineModel);
    MedicineModel getMedicineById(Long id);
    MedicineModel updateMedicine(MedicineModel medicineModel);
    void deleteMedicineById(Long id);


}
