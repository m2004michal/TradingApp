package com.tradingApp.tradingApp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageValidationService {

    public boolean isProvidedImageValid(MultipartFile multipartFile){
        if (isImage(multipartFile) && isSizeAcceptable(multipartFile))
            return isValidFormat(multipartFile);
        return false;
    }

    public boolean isValidFormat(MultipartFile multipartFile){
        if (multipartFile.getContentType() != null || multipartFile.getContentType().length() >= 3) {
            String extension = multipartFile.getContentType().substring(multipartFile.getContentType().length() - 3);
            return extension.equalsIgnoreCase("img") || extension.equalsIgnoreCase("png");
        }
        return false;
    }
    public boolean isImage(MultipartFile multipartFile){
        if (multipartFile.getContentType() != null || multipartFile.getContentType().length() >= 5)
            return multipartFile.getContentType().substring(0, 5).equalsIgnoreCase("image");
        return false;
    }

    public boolean isSizeAcceptable(MultipartFile multipartFile){
        System.out.println(multipartFile.getSize());
        if (multipartFile.getSize() > 1048576)
            throw new RuntimeException("image is too big to be uploaded, maximum size is 1mb");
        return true;
    }


}
