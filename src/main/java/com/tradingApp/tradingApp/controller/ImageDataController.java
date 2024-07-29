package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.service.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
@AllArgsConstructor
public class ImageDataController {

    private final ImageDataService imageDataService;

    @PostMapping("/uploadProfilePicture/{userEntityId}")
    public ResponseEntity<String> uploadImage(@PathVariable Long userEntityId, @RequestParam("image") MultipartFile file) throws IOException {
        imageDataService.uploadProfilePicture(userEntityId, file);
        return new ResponseEntity<>("Profile picture uploaded succesfully", HttpStatus.OK);
    }

}
