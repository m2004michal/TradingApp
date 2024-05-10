package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.CategoryRequest;
import com.tradingApp.tradingApp.mapper.CategoryMapper;
import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.repository.CategoryRepository;
import com.tradingApp.tradingApp.repository.GamesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServcie {

    private final CategoryRepository categoryRepository;
    private final GamesRepository gamesRepository;
    private final CategoryMapper categoryMapper;


    public String createCategory(CategoryRequest categoryRequest) {
        if (validateCategory(categoryRequest)) {
            categoryRepository.save(categoryMapper.mapCategoryRequestToCategory(categoryRequest));
            return "Category created";
        }
            else return "Category with given name already exists";
    }

    public boolean validateCategory(CategoryRequest categoryRequest){
        Optional<Category> categoryByName = categoryRepository
                .findCategoryByNameAndAndGame(categoryRequest.getCategoryName(),
                gamesRepository.findGameByName(categoryRequest.getGameName())
                        .orElseThrow(() -> new IllegalArgumentException("No game with given name found")));
        return categoryByName.isEmpty();
    }
}
