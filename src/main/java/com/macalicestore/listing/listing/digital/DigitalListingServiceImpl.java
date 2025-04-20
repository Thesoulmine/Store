package com.macalicestore.listing.listing.digital;

import com.macalicestore.listing.listing.ConcreteListingService;
import com.macalicestore.listing.listing.Listing;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DigitalListingServiceImpl implements ConcreteListingService {

    private final DigitalListingRepository digitalListingRepository;

    public DigitalListingServiceImpl(DigitalListingRepository digitalListingRepository) {
        this.digitalListingRepository = digitalListingRepository;
    }

    @Override
    public Class<DigitalListing> getEntityClass() {
        return DigitalListing.class;
    }

    @Override
    public void fillListing(Listing listing, MultipartFile[] images) {

    }
}
