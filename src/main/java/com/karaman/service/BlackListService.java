package com.karaman.service;



import com.karaman.model.BlackListModel;

import java.util.List;

public interface BlackListService {
    List<BlackListModel> getAllBlackList();
    BlackListModel saveBlackList(BlackListModel blackListModel);
    BlackListModel getBlackListById(Long id);
    BlackListModel updateBlackList(BlackListModel blackListModel);
    void deleteBlackListById(Long id);
}
