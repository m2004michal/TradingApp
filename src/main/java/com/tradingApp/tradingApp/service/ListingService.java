package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.ListingRequestWithNoPhotos;
import com.tradingApp.tradingApp.mapper.ListingMapper;
import com.tradingApp.tradingApp.model.Listing;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public String deleteListing(Long listingId) {
        AtomicReference<String> toReturn = new AtomicReference<>("Failed to delete listing");
        if (listingRepository.existsById(listingId)) {
            listingRepository.findById(listingId).ifPresent(listing -> {
                if (isLoggedInUserAdmin() || isLoggedInUserOwnerOfListing(listing)) {
                    listingRepository.delete(listing);
                    toReturn.set("Listing deleted successfully");
                }
            });
            return toReturn.get();
        }
        return toReturn.get();
    }

    public boolean isLoggedInUserAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().toString().contains("ADMIN");
    }
    public boolean isLoggedInUserOwnerOfListing(Listing listing){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jwt.getClaim("sub").equals(listing.getUserEntity().getUsername());
    }


}
