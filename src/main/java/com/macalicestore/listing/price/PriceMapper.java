package com.macalicestore.listing.price;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toEntity(PriceDTO priceDTO);

    PriceDTO toDto(Price price);
}