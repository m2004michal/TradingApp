package com.tradingApp.tradingApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Username is required")
    private String username;
    private String phoneNumber;
}
