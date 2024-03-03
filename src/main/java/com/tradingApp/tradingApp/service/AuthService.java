package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.RegisterRequest;
import com.tradingApp.tradingApp.model.Enums.Role;
import com.tradingApp.tradingApp.model.NotificationEmail;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.model.VerificationToken;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import com.tradingApp.tradingApp.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;
    private final FeeService feeService;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;

    public void signup(RegisterRequest registerRequest) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setEmail(registerRequest.getEmail());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userEntity.setPhoneNumber(registerRequest.getPhoneNumber());
        userEntity.setCreatedDate(Date.from(Instant.now()));
        userEntity.setRole(Role.USER);
        userEntity.setEnabled(false);
        userEntity.setLevel(1);
        userEntity.setCurrentFeeFlat(feeService.calculateFeeFlat(userEntity));
        userEntity.setCurrentFeePercentage(feeService.calculateCurrentFeePercentage(userEntity));
        userEntity.setAccountExpired(false);
        userEntity.setLocked(false);
        userEntity.setCredentialsNonExpired(true);

        userEntityRepository.save(userEntity);

        String token = generateVerificationToken(userEntity);
        mailService.sendMail(new NotificationEmail("Please Activate your Account", userEntity.getEmail(), "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(UserEntity userEntity) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(userEntity);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> byToken = verificationTokenRepository.findByToken(token);
        byToken.orElseThrow(() -> new RuntimeException("Invalid Exception"));
        fetchUserAndEnable(byToken.get());
    }
}
