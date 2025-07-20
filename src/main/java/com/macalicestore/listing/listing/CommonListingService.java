package com.macalicestore.listing.listing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public abstract class CommonListingService extends AbstractListingService<Listing, ListingDTO, SaveListingDTO> {

    public abstract Page<Listing> findAll(Set<Class<? extends Listing>> listingClasses, Pageable pageable);
}
