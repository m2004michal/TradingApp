package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.GameRequest;
import com.tradingApp.tradingApp.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("api/games")
@Controller
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/addGame")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN_CREATE')")
    public ResponseEntity<String> signup(@RequestBody GameRequest gameRequest){
        gameService.addGame(gameRequest);
        return new ResponseEntity<>("Game added successfully", HttpStatus.OK);
    }
}
