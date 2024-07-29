package com.tradingApp.tradingApp.mapper;

import com.tradingApp.tradingApp.dto.AuthenticationResponse;
import com.tradingApp.tradingApp.dto.SecureAuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationMapper {
    public SecureAuthenticationResponse mapResponseToSecureResponse(AuthenticationResponse authenticationResponse){
        return SecureAuthenticationResponse.builder()
                .username(authenticationResponse.getUsername())
                .expiresAt(authenticationResponse.getExpiresAt())
                .authenticationToken(authenticationResponse.getAuthenticationToken())
                .id(authenticationResponse.getId())
                .build();
    }
}
