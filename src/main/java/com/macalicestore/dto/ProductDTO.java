package com.macalicestore.dto;

import com.macalicestore.listing.colour.Colour;
import com.macalicestore.listing.listing.Listing;
import lombok.Data;
import org.mapstruct.Mapper;

@Data
@Mapper
public class ProductDTO {

    private Long id;

    private Listing listing;

    private Colour colour;

    private int quantity;
}
