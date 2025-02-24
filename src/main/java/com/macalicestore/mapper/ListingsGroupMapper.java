package com.macalicestore.mapper;

import com.macalicestore.dto.ListingsGroupDTO;
import com.macalicestore.entity.ListingsGroup;
import com.macalicestore.service.ListingsGroupService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ListingsGroupMapper {

    ListingsGroupDTO toDTO(ListingsGroup listingsGroup);

    ListingsGroup toEntity(ListingsGroupDTO listingsGroupDTO);
}
