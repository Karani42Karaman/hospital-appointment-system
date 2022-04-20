package com.karaman.repository;

import com.karaman.model.BlackListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackListModel, Long> {

}
