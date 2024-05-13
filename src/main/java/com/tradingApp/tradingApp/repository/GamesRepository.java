package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {
    Optional<Game> findGameById(Long id);
    Optional<Game> findGameByName(String gameName);
    void deleteGameById(Long id);
}
