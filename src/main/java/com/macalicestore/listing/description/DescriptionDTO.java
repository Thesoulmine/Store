package com.macalicestore.listing.description;

import lombok.Data;
import org.mapstruct.Mapper;

@Data
@Mapper
public class DescriptionDTO {

    private Long id;

    private String description;
}