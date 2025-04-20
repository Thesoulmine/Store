package com.macalicestore.listing.listing.physical;

import com.macalicestore.listing.listing.ConcreteListingService;
import com.macalicestore.listing.listing.Listing;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PhysicalListingServiceImpl implements ConcreteListingService {

    private final PhysicalListingRepository physicalListingRepository;

    public PhysicalListingServiceImpl(PhysicalListingRepository physicalListingRepository) {
        this.physicalListingRepository = physicalListingRepository;
    }

    @Override
    public Class<PhysicalListing> getEntityClass() {
        return PhysicalListing.class;
    }

    @Override
    public void fillListing(Listing listing, MultipartFile[] images) {

    }
}
