package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.GameRequest;
import com.tradingApp.tradingApp.dto.GameResponse;
import com.tradingApp.tradingApp.mapper.GameMapper;
import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.model.Game;
import com.tradingApp.tradingApp.repository.GamesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService {

    private final GameMapper gameMapper;
    private final GamesRepository gamesRepository;

    public ResponseEntity<String> addGame(GameRequest gameRequest) {
        if (gameRequest.getName() == null || gameRequest.getName().isEmpty()) {
            return new ResponseEntity<>("Game added successfully", HttpStatus.BAD_REQUEST);
        }
        gamesRepository.save(gameMapper.mapGameRequestToGame(gameRequest));
        return new ResponseEntity<>("Game added successfully", HttpStatus.OK);
    }

    @Transactional
    public String deleteGameById(long id) {
        String toReturn = "deleted successfully";
        try {
            gamesRepository.findGameById(id).orElseThrow(() -> new RuntimeException("No game with given id found"));
        }catch (RuntimeException ignored){
            toReturn = "not found";
        }
        gamesRepository.deleteGameById(id);
        return toReturn;
    }

    public List<GameResponse> getAllGames() {
        List<Game> allGames = gamesRepository.findAll();
        return allGames.stream().map(game ->
                GameResponse.builder()
                        .gameName(game.getName())
                        .categoriesNames(game.getCategories()
                                .stream()
                                .map(Category::getName).toList())
                        .build())
                .toList();
    }
}
