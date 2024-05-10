package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.*;
import com.tradingApp.tradingApp.mapper.AuthenticationMapper;
import com.tradingApp.tradingApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);

    }
    @PostMapping("refresh/token")
    public ResponseEntity<SecureAuthenticationResponse> refreshTokens(@RequestBody RefreshTokenRequest refreshTokenRequest){
        AuthenticationResponse authenticationResponse = authService.refreshToken(refreshTokenRequest);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Set-Cookie", authService.getAuthenticationTokenCookie(authenticationResponse.getAuthenticationToken()).toString());
        httpHeaders.add("Set-Cookie", authService.getRefreshTokenCookie(authenticationResponse.getRefreshToken()).toString());
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(authenticationMapper.mapResponseToSecureResponse(authenticationResponse));
    }








}
