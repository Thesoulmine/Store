package com.macalicestore.listing.listing.physical;

import com.macalicestore.listing.listing.ListingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhysicalListingRepository extends ListingRepository<PhysicalListing> {
}
