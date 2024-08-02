package com.tradingApp.tradingApp.dto;


import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.model.Photo;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@RequiredArgsConstructor
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
    private List<Photo> photos;


}
