//package com.tradingApp.tradingApp.controller;
//
//import com.tradingApp.tradingApp.dto.DeleteGameRequest;
//import com.tradingApp.tradingApp.dto.GameRequest;
//import com.tradingApp.tradingApp.dto.PostRequest;
//import com.tradingApp.tradingApp.service.GameService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("api/post")
//@Controller
//@AllArgsConstructor
//public class PostController {
//
//    private final GameService gameService;
//
//    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('SCOPE_ADMIN_CREATE')")
//    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest){
//        postService.createPost(postRequest);
//        return new ResponseEntity<>("Post created successfully", HttpStatus.OK);
//    }
//    @PostMapping("/deleteGameById")
//    @PreAuthorize("hasAuthority('SCOPE_ADMIN_DELETE')")
//    public ResponseEntity<String> deleteGameById(@RequestBody DeleteGameRequest deleteGameRequest){
//        return new ResponseEntity<>("Game with id: " + deleteGameRequest.getId() + " " + gameService.deleteGameById(deleteGameRequest.getId()), HttpStatus.OK);
//    }
//
//}
