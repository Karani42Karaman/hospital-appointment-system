package com.karaman.hospitalappointmentsystem.service;

import com.karaman.hospitalappointmentsystem.model.Doctor_Mail;
import com.karaman.hospitalappointmentsystem.model.MedicineModel;

import java.util.List;

public interface MedicineService {
    List<MedicineModel> getMedicinePrescriptionsId(Long prescriptionsId);
    MedicineModel saveMedicine(MedicineModel medicineModel);
}
