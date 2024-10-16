package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.model.Listing;
import com.tradingApp.tradingApp.model.Photo;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.repository.ListingRepository;
import com.tradingApp.tradingApp.repository.PhotoRepository;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageDataService {

    private final UserEntityRepository userEntityRepository;
    private final ImageValidationService imageValidationService;
    private final ListingRepository listingRepository;
    private final PhotoRepository photoRepository;

    @Transactional
    public void uploadProfilePicture(Long userEntityId, MultipartFile multipartFile){
        if (imageValidationService.isProvidedImageValid(multipartFile)) {
            UserEntity userEntity = userEntityRepository.findById(userEntityId).orElseThrow(() -> new RuntimeException("No user with given id found"));
            String name = UUID.randomUUID().toString();
            String toUrl = generateRandomUrl(multipartFile, name);
            try {
                multipartFile.transferTo(new File(toUrl));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userEntity.setProfilePictureUrl(toUrl);
        }
    }

    @Transactional
    public void uploadListingPicture(Long listingId, MultipartFile multipartFile){
        if (imageValidationService.isProvidedImageValid(multipartFile)) {
            Listing listing = listingRepository.findById(listingId).orElseThrow( ()-> new RuntimeException( "no listing with given id found"));
            String name = UUID.randomUUID().toString();
            String path = generateRandomUrl(multipartFile, name);
            try {
                multipartFile.transferTo(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Photo photo = Photo.builder()
                    .listing(listing)
                    .filePath(path)
                    .name(name)
                    .build();
            listing.getPhotos().add(photo);
            listingRepository.save(listing);
        }
    }




    public String getFileExtension(MultipartFile multipartFile) {
        String extension = "";
        if (multipartFile.getContentType() != null || multipartFile.getContentType().length() >= 3) {
            extension = multipartFile.getContentType().substring(multipartFile.getContentType().length() - 3);
            return extension;
        }
        return extension;
    }


    public String generateRandomUrl(MultipartFile multipartFile, String uuid){
        return new File("").getAbsolutePath() +
                "\\src\\main\\resources\\photos\\profilePictures\\" + uuid + "." + getFileExtension(multipartFile);
    }
}
