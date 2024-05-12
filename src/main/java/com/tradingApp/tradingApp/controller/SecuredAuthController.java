package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.LogoutRequest;
import com.tradingApp.tradingApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/securedAuth")
@AllArgsConstructor
public class SecuredAuthController {

    private final AuthService authService;
    @PostMapping("/account/logout")
    public ResponseEntity<String> logout(@RequestBody LogoutRequest logoutRequest){
        authService.logout(logoutRequest);
        return new ResponseEntity<>("Logout Successful", HttpStatus.OK);
    }
}