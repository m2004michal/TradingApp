package com.tradingApp.tradingApp.dto;

import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ListingRequestWithNoPhotos {

    private String title;
    private String description;
    private int quantity;
    private BigDecimal price;
    private boolean isForTrade;
    private boolean isForSale;
    private boolean isNegotiable;
    private boolean isQuickBuy;
    private String gameName;
    private String categoryName;
}
