package com.macalicestore.listing.description;

import lombok.Data;
import org.mapstruct.Mapper;

@Data
public class DescriptionDTO {

    private Long id;

    private String text;
}