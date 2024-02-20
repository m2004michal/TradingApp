package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, long> {
}
