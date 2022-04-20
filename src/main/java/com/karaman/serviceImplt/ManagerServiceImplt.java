package com.karaman.serviceImplt;

import com.karaman.model.ManagerModel;
import com.karaman.repository.ManagerRepository;
import com.karaman.service.ManagerService;
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
}
