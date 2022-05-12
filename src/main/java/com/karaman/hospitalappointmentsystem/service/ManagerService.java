package com.karaman.hospitalappointmentsystem.service;

import com.karaman.hospitalappointmentsystem.model.ManagerModel;

import java.util.List;

public interface ManagerService {

    List<ManagerModel> getAllManager();
    ManagerModel saveManager(ManagerModel managerModel);
    ManagerModel getManagerById(Long id);
    ManagerModel updateManager(ManagerModel managerModel);
    void deleteManagerById(Long id);
    ManagerModel getManagerModelBy(Long TCNumber, String password);
}
