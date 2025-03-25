package com.tradingApp.tradingApp.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameRequest {
    @NotBlank(message = "gameNameRequired")
    private String name;
}
