package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.model.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeeService {
    public double calculateFeeFlat(UserEntity userEntity) {
        return 0.5 /userEntity.getLevel();
    }

    public double calculateCurrentFeePercentage(UserEntity userEntity) {
        return 0.1 /userEntity.getLevel();
    }
}
