package com.macalicestore.listing.image;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageDTO toDTO(Image image);

    Image toEntity(ImageDTO imageDTO);
}
