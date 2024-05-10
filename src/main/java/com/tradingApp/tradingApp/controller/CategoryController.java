package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.CategoryRequest;
import com.tradingApp.tradingApp.service.CategoryServcie;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/category")
@Controller
@AllArgsConstructor
public class CategoryController {

    private final CategoryServcie categoryServcie;
    @PostMapping("/createCategory")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN_CREATE')")
    public ResponseEntity<String> createCategory(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryServcie.createCategory(categoryRequest), HttpStatus.OK);
    }


}
