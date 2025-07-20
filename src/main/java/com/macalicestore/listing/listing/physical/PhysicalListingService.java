package com.macalicestore.listing.listing.physical;

import com.macalicestore.listing.listing.ConcreteListingService;
import org.springframework.stereotype.Service;

@Service
public class PhysicalListingService extends ConcreteListingService<PhysicalListing, PhysicalListingDTO, SavePhysicalListingDTO> {

    @Override
    public Class<PhysicalListing> getEntityClass() {
        return PhysicalListing.class;
    }

    @Override
    public Class<PhysicalListingDTO> getDTOClass() {
        return PhysicalListingDTO.class;
    }

    @Override
    public Class<SavePhysicalListingDTO> getSaveDTOClass() {
        return SavePhysicalListingDTO.class;
    }

    @Override
    protected void fillConcreteListing(PhysicalListing listing, SavePhysicalListingDTO saveListingDTO) {

    }
}
