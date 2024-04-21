package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.GameRequest;
import com.tradingApp.tradingApp.mapper.GameMapper;
import com.tradingApp.tradingApp.repository.GamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    private final GameMapper gameMapper;
    private final GamesRepository gamesRepository;

    public void addGame(GameRequest gameRequest) {
        gamesRepository.save(gameMapper.mapGameRequestToGame(gameRequest));
    }
}
