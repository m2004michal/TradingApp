package com.tradingApp.tradingApp.dto;

import com.tradingApp.tradingApp.mapper.ListingMapper;

import com.tradingApp.tradingApp.repository.CategoryRepository;
import com.tradingApp.tradingApp.repository.ListingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ListingRequest {

    private final CategoryRepository categoryRepository;
    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;

//    @Transactional
//    public void save(ListingRequest listingRequest) {
//        Category category = categoryRepository.findCategoryByNameAndGame(listingRequest.getCategoryName(), listingRequest.getGame)
//                .orElseThrow(() -> new IllegalArgumentException("No category with name: " + listingRequest.getCategoryName() + " found"));
//        listingRepository.save(listingMapper.map(listingRequest, category, authService.getCurrentUser()));
//    }
}
