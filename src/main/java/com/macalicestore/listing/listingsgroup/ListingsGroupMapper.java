package com.macalicestore.listing.listingsgroup;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListingsGroupMapper {

    ListingsGroupDTO toDTO(ListingsGroup listingsGroup);

    ListingsGroup toEntity(ListingsGroupDTO listingsGroupDTO);
}
