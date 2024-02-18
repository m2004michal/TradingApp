package com.tradingApp.tradingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;

@Entity
public class UserEntity {

    @Id()
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

}
