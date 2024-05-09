package com.tradingApp.tradingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecureAuthenticationResponse {
    private Instant expiresAt;
    private String username;
}
