package com.macalicestore.listing.listing;

import com.macalicestore.listing.listing.physical.PhysicalListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository<T extends Listing> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
