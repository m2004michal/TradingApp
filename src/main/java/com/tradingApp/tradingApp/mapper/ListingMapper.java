package com.tradingApp.tradingApp.mapper;

import com.tradingApp.tradingApp.dto.ListingRequest;
import com.tradingApp.tradingApp.model.Listing;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import com.tradingApp.tradingApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ListingMapper {

    private final AuthService authService;
    private final UserEntityRepository userEntityRepository;

    public Listing mapDtoToListing(ListingRequest listingRequest){
        return Listing.builder()
                .userEntity(userEntityRepository.findById(authService.getCurrentUserId())
                        .orElseThrow(() -> new RuntimeException("no user with given id found")))
                .createdDate(Date.from(Instant.now()))
                .title(listingRequest.getTitle())
                .description(listingRequest.getDescription())
                .quantity(listingRequest.getQuantity())
                .views(0)
                .isQuickBuy(listingRequest.isQuickBuy())
                .isNegotiable(listingRequest.isNegotiable())
                .isForSale(listingRequest.isForSale())
                .isForTrade(listingRequest.isForTrade())
                .isPromoted(false)
                .category(listingRequest.getCategory())
                .price(listingRequest.getPrice())
                .photos(listingRequest.getPhotos())
                .url(UUID.randomUUID().toString())
                .build();

    }
}
