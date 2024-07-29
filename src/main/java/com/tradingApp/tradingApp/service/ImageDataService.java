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

    @Transactional
    public void uploadProfilePicture(Long userEntityId, MultipartFile multipartFile) throws IOException {
        UserEntity userEntity = userEntityRepository.findById(userEntityId).orElseThrow(() -> new RuntimeException("No user with given id found"));
        String toUrl = UUID.randomUUID().toString();
        String filePath = new File("").getAbsolutePath();
        String newString = "." + multipartFile.getContentType().substring(multipartFile.getContentType().length()-3);
        String path = filePath + "/src/main/resources/photos/profilePictures/" + toUrl + newString;
        File file = new File(path);
        multipartFile.transferTo(file);
        userEntity.setProfilePictureUrl(path);
    }

}
