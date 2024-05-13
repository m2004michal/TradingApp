package com.tradingApp.tradingApp.mapper;

import com.tradingApp.tradingApp.dto.GameRequest;
import com.tradingApp.tradingApp.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {

    public Game mapGameRequestToGame(GameRequest gameRequest){
        return Game.builder()
                .name(gameRequest.getName()).build();
    }


}
