package com.macalicestore.listing.listing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ListingService {

    Page<Listing> findAllListings(Pageable pageable);

    Page<Listing> findAllListings(Set<Class<? extends Listing>> listingClasses, Pageable pageable);

    Listing findListingById(Long id);

    Listing saveListing(Listing listing, MultipartFile[] images);

    void deleteListing(Long id);

    Listing updateListing(Listing listing, MultipartFile[] images);
}
