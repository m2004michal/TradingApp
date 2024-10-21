package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.*;
import com.tradingApp.tradingApp.mapper.AuthenticationMapper;
import com.tradingApp.tradingApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.server.Cookie;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;


@Controller
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationMapper authenticationMapper;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }
    @GetMapping("/verifyAccount/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("User verified successful", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<SecureAuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        AuthenticationResponse login = authService.login(loginRequest);
        httpHeaders.add("Set-Cookie", authService.getRefreshTokenCookie(login.getRefreshToken()).toString());
        if (loginRequest.isRememberMe()){
            httpHeaders.setAccessControlMaxAge(860000);
        }
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(authenticationMapper.mapResponseToSecureResponse(login));
    }

    @PostMapping("refresh/token")
    public ResponseEntity<SecureAuthenticationResponse> refreshTokens(@RequestBody RefreshTokenRequest refreshTokenRequest, @CookieValue(name = "RefreshToken") String refreshToken){
        AuthenticationResponse authenticationResponse = authService.refreshTokenUsingCookie(refreshTokenRequest.getUsername(), refreshToken);
        return new ResponseEntity<>(authenticationMapper.mapResponseToSecureResponse(authenticationResponse), HttpStatus.OK);
    }
}