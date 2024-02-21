package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {
}
