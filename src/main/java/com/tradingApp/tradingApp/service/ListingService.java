package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.ListingRequest;
import com.tradingApp.tradingApp.mapper.ListingMapper;
import com.tradingApp.tradingApp.model.Listing;
import com.tradingApp.tradingApp.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListingService {

    private final ListingMapper listingMapper;
    private final ListingRepository listingRepository;

    public void save(ListingRequest listingRequest) {
        Listing listing = listingMapper.mapDtoToListing(listingRequest);
        listingRepository.save(listing);
    }
}
