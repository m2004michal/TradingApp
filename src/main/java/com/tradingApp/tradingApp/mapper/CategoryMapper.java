package com.tradingApp.tradingApp.mapper;

import com.tradingApp.tradingApp.dto.CategoryRequest;
import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.repository.GamesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryMapper {

    private final GamesRepository gamesRepository;

    public Category mapCategoryRequestToCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.getCategoryName())
                .game(gamesRepository.findGameByName(categoryRequest.getGameName())
                        .orElseThrow(() -> new IllegalArgumentException("No game with name: " + categoryRequest.getGameName() + " found")))
                .build();
    }
}
