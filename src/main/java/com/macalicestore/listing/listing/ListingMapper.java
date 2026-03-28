package com.macalicestore.listing.listing;

import com.macalicestore.listing.listing.digital.DigitalListing;
import com.macalicestore.listing.listing.digital.DigitalListingDTO;
import com.macalicestore.listing.listing.digital.SaveDigitalListingDTO;
import com.macalicestore.listing.listing.physical.PhysicalListing;
import com.macalicestore.listing.listing.physical.PhysicalListingDTO;
import com.macalicestore.listing.listing.physical.SavePhysicalListingDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListingMapper {

    @Mapping(target = "images", ignore = true)
    @SubclassMapping(source = PhysicalListing.class, target = PhysicalListingDTO.class)
    @SubclassMapping(source = DigitalListing.class, target = DigitalListingDTO.class)
    ListingDTO toDTO(Listing listing);

    @Mapping(target = "images", ignore = true)
    @SubclassMapping(source = PhysicalListingDTO.class, target = PhysicalListing.class)
    @SubclassMapping(source = DigitalListingDTO.class, target = DigitalListing.class)
    Listing toEntity(ListingDTO listingDTO);

    @Mapping(target = "images", ignore = true)
    @SubclassMapping(source = PhysicalListing.class, target = SavePhysicalListingDTO.class)
    @SubclassMapping(source = DigitalListing.class, target = SaveDigitalListingDTO.class)
    SaveListingDTO toSaveDTO(Listing listing);

    @Mapping(target = "images", ignore = true)
    @SubclassMapping(source = SavePhysicalListingDTO.class, target = PhysicalListing.class)
    @SubclassMapping(source = SaveDigitalListingDTO.class, target = DigitalListing.class)
    Listing toEntity(SaveListingDTO listingDTO);
}
