package com.macalicestore.listing.title;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TitleMapper {

    Title toEntity(TitleDTO titleDTO);

    TitleDTO toDto(Title title);
}