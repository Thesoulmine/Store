package com.macalicestore.listing.listing;

import com.macalicestore.listing.category.Category;
import com.macalicestore.listing.colour.Colour;
import com.macalicestore.listing.description.Description;
import com.macalicestore.listing.material.Material;
import com.macalicestore.listing.size.Size;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ListingService {

    List<Listing> findAllListings();

    Listing findListingById(Long id);

    void saveListing(Listing listing, String listingType, MultipartFile[] images) throws IOException;
}
