package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.ListingRequestWithNoPhotos;
import com.tradingApp.tradingApp.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("api/listings")
@Controller
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @PostMapping("/create")
    public ResponseEntity<String> createListing(@ModelAttribute ListingRequestWithNoPhotos listingRequestWithNoPhotos, @RequestParam("images") List<MultipartFile> images) {
        listingService.save(listingRequestWithNoPhotos, images);
        return new ResponseEntity<>("Post created succesfully", HttpStatus.CREATED);
    }
}
