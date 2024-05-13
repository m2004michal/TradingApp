package com.tradingApp.tradingApp.controller;

import com.tradingApp.tradingApp.dto.DeleteGameRequest;
import com.tradingApp.tradingApp.dto.GameRequest;
import com.tradingApp.tradingApp.dto.GameResponse;
import com.tradingApp.tradingApp.model.Game;
import com.tradingApp.tradingApp.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/games")
@Controller
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/addGame")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN_CREATE')")
    public ResponseEntity<String> addGame(@RequestBody GameRequest gameRequest){
        gameService.addGame(gameRequest);
        return new ResponseEntity<>("Game added successfully", HttpStatus.OK);
    }
    @PostMapping("/deleteGameById")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN_DELETE')")
    public ResponseEntity<String> deleteGameById(@RequestBody DeleteGameRequest deleteGameRequest){
        return new ResponseEntity<>("Game with id: " + deleteGameRequest.getId() + " " + gameService.deleteGameById(deleteGameRequest.getId()), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameResponse>> getAllGames(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

}
