package com.macalicestore.listing.listing;

import com.macalicestore.entity.DigitalListing;
import com.macalicestore.entity.PhysicalListing;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListingMapper {

    @Mapping(target = "images", ignore = true)
    ListingDTO toDTO(Listing listing);

    @Mapping(target = "images", ignore = true)
    @SubclassMapping(source = PhysicalListingDTO.class, target = PhysicalListing.class)
    @SubclassMapping(source = DigitalListingDTO.class, target = DigitalListing.class)
    Listing toEntity(ListingDTO listingDTO);

    List<Listing> toEntity(List<ListingDTO> listingDTO);

    List<ListingDTO> toDto(List<Listing> listing);
}
