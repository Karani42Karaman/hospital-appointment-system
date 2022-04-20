package com.karaman.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="appointment")
public class BlackListModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name="blacklist_id")
    private Long blackListId;


    @Column(name="number_of_additions")
    private Long numberOfAdditions;

    @Column(name="description")
    private String description;



}
