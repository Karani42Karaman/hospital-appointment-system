package com.karaman.hospitalappointmentsystem.service;



import com.karaman.hospitalappointmentsystem.model.BlackListModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlackListService {
    List<BlackListModel> getAllBlackList();
    BlackListModel saveBlackList(BlackListModel blackListModel);
    BlackListModel getBlackListById(Long id);
    BlackListModel updateBlackList(BlackListModel blackListModel);
    void deleteBlackListById(Long id);
    Long getBlackListPatinetCount(Long patientId);
    @Transactional
    void deleteApp(Long appointId);
    @Transactional
    void deleteBlackListByDoctorId(Long doctorId);
}
