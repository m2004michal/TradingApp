package com.tradingApp.tradingApp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("api/admin")
@Controller
@AllArgsConstructor
public class AdminController {
    @GetMapping("/getRole")
    public ResponseEntity<String> getRoleForLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String toRespond;
        if (authentication.getAuthorities().toString().contains("ADMIN"))
            toRespond = "ADMIN";
        else
            toRespond = "USER";
        return new ResponseEntity<>(toRespond, HttpStatus.OK);
    }




}
