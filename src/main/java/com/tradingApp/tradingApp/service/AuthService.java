package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.RegisterRequest;
import com.tradingApp.tradingApp.model.Enums.Role;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserEntityRepository userEntityRepository;

    public void signup(RegisterRequest registerRequest) {

        Role role = Role.USER;

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setEmail(registerRequest.getEmail());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userEntity.setPhoneNumber(registerRequest.getPhoneNumber());
        userEntity.setCreatedDate(Date.from(Instant.now()));
        userEntity.setRole(Role.USER);
        userEntity.setEnabled(false);
        userEntity.setLevel(1);
        userEntity.setCurrentFeeFlat(feeService.calculateFee(userEntity));
        userEntity.setCurrentFeePercentage(feeService.calculateCurrentFeePercentage(userEntity));
        userEntity.setAccountExpired(false);
        userEntity.setLocked(false);
        userEntity.setCredentialsNonExpired(true);

        userEntityRepository.save(userEntity);

        String token = generateVerificationToken(userEntity);
        mailService.sendMail(new NotificationEmail("Please Activate your Account", userEntity.getEmail(), "http://localhost:8080/api/auth/accountVerification/" + token));
    }
}
