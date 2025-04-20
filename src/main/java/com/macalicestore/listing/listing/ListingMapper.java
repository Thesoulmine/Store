package com.macalicestore.listing.listing;

import com.macalicestore.listing.listing.digital.DigitalListing;
import com.macalicestore.listing.listing.digital.DigitalListingDTO;
import com.macalicestore.listing.listing.physical.PhysicalListing;
import com.macalicestore.listing.listing.physical.PhysicalListingDTO;
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

    List<Listing> toEntity(List<ListingDTO> listingDTO);

    List<ListingDTO> toDto(List<Listing> listing);
}
