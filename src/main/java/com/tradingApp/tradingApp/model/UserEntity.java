package com.tradingApp.tradingApp.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
public class UserEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private double balance;
    @Nullable
    private String name;
    @Nullable
    private String surename;
    private Date createdDate;
    private double currentFeeFlat;
    private double currentFeePercentage;
    private int level;

    //ratings
    //transactions
    //topUps
    //previouslyUsedPasswords;
    //profilePic
    //reports
    //roles
}