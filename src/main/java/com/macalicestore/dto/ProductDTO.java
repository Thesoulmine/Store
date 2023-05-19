package com.macalicestore.dto;

import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Listing;
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
