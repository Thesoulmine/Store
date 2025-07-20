package com.macalicestore.listing.listing.digital;

import com.macalicestore.listing.listing.ListingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DigitalListingRepository extends ListingRepository<DigitalListing> {
}
