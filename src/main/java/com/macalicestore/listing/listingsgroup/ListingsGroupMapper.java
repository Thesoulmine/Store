package com.macalicestore.listing.listingsgroup;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListingsGroupMapper {

    @Mapping(target = "mainImage", ignore = true)
    ListingsGroupDTO toDTO(ListingsGroup listingsGroup);

    List<ListingsGroupDTO> toDTO(List<ListingsGroup> listingsGroup);

    @Mapping(target = "mainImage", ignore = true)
    ListingsGroup toEntity(ListingsGroupDTO listingsGroupDTO);

    List<ListingsGroup> toEntity(List<ListingsGroupDTO> listingsGroupDTO);
}
