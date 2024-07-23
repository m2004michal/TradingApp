package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.ListingRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/listings")
@Controller
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;

//    @PostMapping
//    public ResponseEntity<String> createListing(@RequestBody ListingRequest listingRequest) {
//        listingRequest.save(listingRequest);
//        return new ResponseEntity<>("Post created succesfully", HttpStatus.CREATED);
//    }
}
