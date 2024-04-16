package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.AuthenticationResponse;
import com.tradingApp.tradingApp.dto.LoginRequest;
import com.tradingApp.tradingApp.dto.RefreshTokenRequest;
import com.tradingApp.tradingApp.dto.RegisterRequest;
import com.tradingApp.tradingApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

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
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);

    }
    @PostMapping("refresh/token")
    public ResponseEntity<AuthenticationResponse> refreshTokens( @RequestBody RefreshTokenRequest refreshTokenRequest){
        return new ResponseEntity<>(authService.refreshToken(refreshTokenRequest), HttpStatus.OK);
    }






}
