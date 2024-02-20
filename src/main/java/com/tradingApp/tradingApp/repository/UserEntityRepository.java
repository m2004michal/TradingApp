package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
