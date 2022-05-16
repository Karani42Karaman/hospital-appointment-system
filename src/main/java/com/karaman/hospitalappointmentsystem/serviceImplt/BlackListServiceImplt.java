package com.karaman.hospitalappointmentsystem.serviceImplt;

import com.karaman.hospitalappointmentsystem.model.BlackListModel;
import com.karaman.hospitalappointmentsystem.repository.BlackListRepository;
import com.karaman.hospitalappointmentsystem.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlackListServiceImplt implements BlackListService {

    @Autowired
    private BlackListRepository blackListRepository;

    public BlackListServiceImplt(BlackListRepository blackListRepository) {
        this.blackListRepository = blackListRepository;
    }


    @Override
    public List<BlackListModel> getAllBlackList() {
        return blackListRepository.findAll();
    }

    @Override
    public BlackListModel saveBlackList(BlackListModel blackListModel) {
        return blackListRepository.save(blackListModel);
    }

    @Override
    public BlackListModel getBlackListById(Long id) {
        return blackListRepository.getById(id);
    }

    @Override
    public BlackListModel updateBlackList(BlackListModel blackListModel) {
        return blackListRepository.save(blackListModel);
    }

    @Override
    public void deleteBlackListById(Long id) {
        blackListRepository.deleteById(id);
    }

    @Override
    public Long getBlackListPatinetCount(Long patientId) {
        return blackListRepository.getBlackListPatinetCount(patientId);
    }

    @Override
    @Transactional
    public void deleteApp(Long appointId) {
        blackListRepository.deleteApp(appointId);
    }
}
