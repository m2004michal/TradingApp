package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.*;
import com.tradingApp.tradingApp.model.Enums.Role;
import com.tradingApp.tradingApp.model.NotificationEmail;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.model.VerificationToken;
import com.tradingApp.tradingApp.repository.RefreshTokenRepository;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import com.tradingApp.tradingApp.repository.VerificationTokenRepository;
import com.tradingApp.tradingApp.security.JwtProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;
    private final FeeService feeService;
    private final AuthenticationManager authenticationManager;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    private final RefreshTokenRepository refreshTokenRepository;
    private static final int expireWhenBrowserClosed = -1;

    @Transactional
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
        userEntity.setPhoneNumberVerified(false);
        userEntityRepository.save(userEntity);
        String token = generateVerificationToken(userEntity);
        mailService.sendMail(new NotificationEmail("Please Activate your Account", userEntity.getEmail(), "http://localhost:8080/api/auth/verifyAccount/" + token));
    }

    private String generateVerificationToken(UserEntity userEntity) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(userEntity);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    @Transactional
    public void verifyAccount(String token) {
        Optional<VerificationToken> byToken = verificationTokenRepository.findByToken(token);
        byToken.orElseThrow(() -> new RuntimeException("Invalid Exception"));
        fetchUserAndEnable(byToken.get());
        verificationTokenRepository.deleteVerificationTokenByToken(token);
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        UserEntity byUsername = userEntityRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("no user found with username: " + username));
        byUsername.setEnabled(true);
        userEntityRepository.save(byUsername);

    }

    @Transactional
    public AuthenticationResponse login(LoginRequest loginRequest) {
        String username = findUsernameFromIdentifier(loginRequest.getIdentifier());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        String token = jwtProvider.generateToken(authenticate);

        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(username)
                .build();
    }

    private boolean isIdentifierAnEmail(String identifier){
        return identifier.contains("@");
    }
    private boolean isIdentifierAPhoneNumber(String identifier){return identifier.contains("+");}
    private String findUsernameFromIdentifier(String identifier){
        if(isIdentifierAPhoneNumber(identifier)) {
            UserEntity userEntity = userEntityRepository.findByPhoneNumber(identifier)
                    .orElseThrow(() -> new RuntimeException("No user with provided phoneNumber found"));
            return userEntity.getUsername();
        }else if (isIdentifierAnEmail(identifier)) {
            UserEntity userEntity = userEntityRepository.findByEmail(identifier)
                    .orElseThrow(() -> new RuntimeException("No user with provided email found"));
            return userEntity.getUsername();
        }else return identifier;
    }

    public AuthenticationResponse refreshTokenUsingCookie(String username, String refreshToken){
        System.out.println(refreshToken);
        refreshTokenService.validateRefreshToken(refreshToken);
        String token = jwtProvider.generateTokenWithUsername(username);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshToken)
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(username)
                .build();
    }

    @Transactional
    public void logout(LogoutRequest logoutRequest) {
        refreshTokenRepository.deleteRefreshTokenByToken(logoutRequest.getRefreshToken()).orElseThrow(() -> new RuntimeException("token not found"));
    }

    public HttpCookie getRefreshTokenCookie(String refreshToken){
        return ResponseCookie.from("RefreshToken", refreshToken)
                .httpOnly(true)
                .maxAge(expireWhenBrowserClosed)
                .path("/")
                .domain("localhost")
//                .sameSite("None")
//                .secure(true)
                // po przerzuceniu na https odkomentowac!!!!!!!
                .build();
    }

    public long getCurrentUserId() {
        Jwt principal = (Jwt) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userEntityRepository.findByUsername(principal.getSubject())
                .orElseThrow(() -> new RuntimeException("User name not found - " + principal.getSubject())).getId();
    }

    public boolean isLoggedUserSameAsProvided(UserEntity userEntity) {
        return userEntity.getId().equals(getCurrentUserId());
    }
}