package com.macalicestore.listing.listing.digital;

import com.macalicestore.listing.listing.ConcreteListingService;
import org.springframework.stereotype.Service;

@Service
public class DigitalListingService extends ConcreteListingService<DigitalListing, DigitalListingDTO, SaveDigitalListingDTO> {

    @Override
    public Class<DigitalListing> getEntityClass() {
        return DigitalListing.class;
    }

    @Override
    public Class<DigitalListingDTO> getDTOClass() {
        return DigitalListingDTO.class;
    }

    @Override
    public Class<SaveDigitalListingDTO> getSaveDTOClass() {
        return SaveDigitalListingDTO.class;
    }

    @Override
    protected void fillConcreteListing(DigitalListing listing, SaveDigitalListingDTO saveListingDTO) {

    }
}
