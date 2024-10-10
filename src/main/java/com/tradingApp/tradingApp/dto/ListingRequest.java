package com.tradingApp.tradingApp.dto;


import com.tradingApp.tradingApp.model.Category;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ListingRequest {

    private String title;
    private String description;
    private int quantity;
    private BigDecimal price;
    private boolean isForTrade;
    private boolean isForSale;
    private boolean isNegotiable;
    private boolean isQuickBuy;
    private Category category;
    private List<MultipartFile> photosAsMultipart;

}
