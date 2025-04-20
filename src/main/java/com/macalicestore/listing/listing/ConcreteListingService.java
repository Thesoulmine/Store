package com.macalicestore.listing.listing;

import org.springframework.web.multipart.MultipartFile;

public interface ConcreteListingService {

    Class<? extends Listing> getEntityClass();

    void fillListing(Listing listing, MultipartFile[] images);
}
