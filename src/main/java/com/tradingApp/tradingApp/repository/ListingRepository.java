package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    Optional<Listing> getListingsById(Long id);
    Optional<List<Listing>> findAllByIsPromoted(boolean isPromoted);
}
