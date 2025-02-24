package com.macalicestore.listing.listing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query("SELECT i FROM Listing i JOIN FETCH i.categories")
    List<Listing> getAll();
}
