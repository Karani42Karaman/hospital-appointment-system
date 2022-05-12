package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.repository.ManagerRepository;
import com.karaman.hospitalappointmentsystem.model.ManagerModel;
import com.karaman.hospitalappointmentsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImplt implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public ManagerServiceImplt(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public List<ManagerModel> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public ManagerModel saveManager(ManagerModel managerModel) {
        return managerRepository.save(managerModel);
    }

    @Override
    public ManagerModel getManagerById(Long id) {
        return managerRepository.getById(id);
    }

    @Override
    public ManagerModel updateManager(ManagerModel managerModel) {
        return managerRepository.save(managerModel);
    }

    @Override
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public ManagerModel getManagerModelBy(Long TCNumber, String password) {
        return managerRepository.getManagerModelBy(TCNumber, password);
    }
}
