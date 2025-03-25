package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.ListingRequestWithNoPhotos;
import com.tradingApp.tradingApp.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("api/listings")
@Controller
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @PostMapping("/create")
    public ResponseEntity<String> createListing(@RequestParam("title") String title,
                                                @RequestParam("description") String description,
                                                @RequestParam("quantity") int quantity,
                                                @RequestParam("price") BigDecimal price,
                                                @RequestParam("isForTrade") boolean isForTrade,
                                                @RequestParam("isForSale") boolean isForSale,
                                                @RequestParam("isNegotiable") boolean isNegotiable,
                                                @RequestParam("isQuickBuy") boolean isQuickBuy,
                                                @RequestParam("gameName") String gameName,
                                                @RequestParam("categoryName") String categoryName,
                                                @RequestParam("images") List<MultipartFile> images) {
        listingService.save(ListingRequestWithNoPhotos.builder()
                .title(title)
                .description(description)
                .quantity(quantity)
                .price(price)
                .isForTrade(isForTrade)
                .isForSale(isForSale)
                .isNegotiable(isNegotiable)
                .isQuickBuy(isQuickBuy)
                .gameName(gameName)
                .categoryName(categoryName)
                .build(), images);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{listingId}")
    public ResponseEntity<String> deleteListing(@PathVariable Long listingId) {
        return new ResponseEntity<>(listingService.deleteListing(listingId), HttpStatus.CREATED);

    }

}
