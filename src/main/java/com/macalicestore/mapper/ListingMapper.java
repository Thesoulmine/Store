package com.macalicestore.mapper;

import com.macalicestore.dto.ListingDTO;
import com.macalicestore.dto.ProductDTO;
import com.macalicestore.entity.Listing;
import com.macalicestore.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListingMapper {

    ListingMapper INSTANCE = Mappers.getMapper(ListingMapper.class);

    @Mapping(target = "images", ignore = true)
    ListingDTO toDTO(Listing listing);

    @Mapping(target = "images", ignore = true)
    Listing toEntity(ListingDTO listingDTO);
}
