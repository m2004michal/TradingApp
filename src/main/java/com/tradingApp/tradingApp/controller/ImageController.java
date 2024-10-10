package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.service.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/image")
@AllArgsConstructor
public class ImageController {

    private final ImageDataService imageDataService;

//    @PostMapping("/upload/{postID}")
//    public ResponseEntity<String> uploadImage(@PathVariable Long listingId, @RequestParam("image") MultipartFile file) throws IOException {
//        imageDataService.uploadImage(listingId, file);
//        return new ResponseEntity<>("Image uploaded succesfully", HttpStatus.CREATED);
//    }
}
