package com.tradingApp.tradingApp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message = "Post Name is required")
    private String postName;
    @NotBlank(message = "Description is required")
    private String gameName;
    private String description;
    private String categoryName;
    private int price;
}
