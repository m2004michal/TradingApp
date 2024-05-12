package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.CategoryRequest;
import com.tradingApp.tradingApp.mapper.CategoryMapper;
import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.model.Game;
import com.tradingApp.tradingApp.repository.CategoryRepository;
import com.tradingApp.tradingApp.repository.GamesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServcie {

    private final CategoryRepository categoryRepository;
    private final GamesRepository gamesRepository;
    private final CategoryMapper categoryMapper;


    @Transactional
    public String createCategory(CategoryRequest categoryRequest) {
        if (validateCategory(categoryRequest)) {
            categoryRepository.save(categoryMapper.mapCategoryRequestToCategory(categoryRequest));
            return "Category created";
        }
            else return "Category with given name already exists";
    }

    public boolean validateCategory(CategoryRequest categoryRequest){
        Optional<Category> categoryByName = categoryRepository
                .findCategoryByNameAndGame(categoryRequest.getCategoryName(),
                        gamesRepository.findGameByName(categoryRequest.getGameName())
                                .orElseThrow(() -> new IllegalArgumentException("No game with given name found")));
        return categoryByName.isEmpty();
    }

    @Transactional
    public String deleteCategoryFromGame(String gameName, String categoryName) {
        Game game = gamesRepository.findGameByName(gameName)
                .orElseThrow(() -> new IllegalArgumentException("Game with name: " + gameName + " not found"));
        Optional<Category> category = categoryRepository.findCategoryByNameAndGame(categoryName, game);
        String message;
        if (category.isPresent()){
            message = "category deleted successfully";
            categoryRepository.deleteCategoryById(category.get().getId());
        }
        else
            message =  "Category with name: " + categoryName + " not found for game with name of: " + gameName;
        return message;
    }
}
