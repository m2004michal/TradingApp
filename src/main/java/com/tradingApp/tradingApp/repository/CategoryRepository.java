package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Category;
import com.tradingApp.tradingApp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByNameAndAndGame (String categoryName, Game game);

}
