package com.karaman.serviceImplt;

import com.karaman.model.BlackListModel;
import com.karaman.repository.BlackListRepository;
import com.karaman.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}