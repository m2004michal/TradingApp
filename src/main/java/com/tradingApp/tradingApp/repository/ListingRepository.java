package com.tradingApp.tradingApp.repository;

import com.tradingApp.tradingApp.model.Listing;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends PagingAndSortingRepository<Listing, Long> {
    Optional<List<Listing>> findAllByIsPromoted(boolean isPromoted);
}
