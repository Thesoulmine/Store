package com.macalicestore.listing.description;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DescriptionMapper {
    Description toEntity(DescriptionDTO descriptionDTO);

    DescriptionDTO toDto(Description description);
}