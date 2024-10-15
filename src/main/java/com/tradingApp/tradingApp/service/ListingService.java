package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.ListingRequest;
import com.tradingApp.tradingApp.dto.ListingRequestWithNoPhotos;
import com.tradingApp.tradingApp.mapper.ListingMapper;
import com.tradingApp.tradingApp.model.Listing;
import com.tradingApp.tradingApp.model.Photo;
import com.tradingApp.tradingApp.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ListingService {

    private final ListingMapper listingMapper;
    private final ListingRepository listingRepository;
    private final ImageDataService imageDataService;

    public void save(ListingRequestWithNoPhotos listingRequestWithNoPhotos, List<MultipartFile> images) {
        Listing listing = listingMapper.mapDtoToListing(listingRequestWithNoPhotos);
        Long id = listingRepository.save(listing).getId();
        savePhotosForListing(id, images);
    }

    public void savePhotosForListing(Long listingId, List<MultipartFile> multipartFiles){
        multipartFiles.forEach((photo) -> imageDataService.uploadListingPicture(listingId, photo));
    }


}
