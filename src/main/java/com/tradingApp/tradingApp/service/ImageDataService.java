package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageDataService {

    private final UserEntityRepository userEntityRepository;
    private final ImageValidationService imageValidationService;

    @Transactional
    public void uploadProfilePicture(Long userEntityId, MultipartFile multipartFile){
        if (imageValidationService.isProvidedImageValid(multipartFile)) {
            UserEntity userEntity = userEntityRepository.findById(userEntityId).orElseThrow(() -> new RuntimeException("No user with given id found"));
            String toUrl = UUID.randomUUID().toString();
            String path = new File("").getAbsolutePath() +
                    "/src/main/resources/photos/profilePictures/" + toUrl + "." + getFileExtension(multipartFile);
            try {
                multipartFile.transferTo(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userEntity.setProfilePictureUrl(path);
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
}
