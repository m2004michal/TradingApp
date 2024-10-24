package com.tradingApp.tradingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginRequest {
    private String identifier;
    private String password;
    private boolean rememberMe;
}
