package com.macalicestore.purchase;

import com.macalicestore.listing.colour.Colour;
import com.macalicestore.listing.listing.Listing;
import lombok.Data;
import org.mapstruct.Mapper;

@Data
public class PurchaseDTO {

    private Long id;

    private Listing listing;

    private Colour colour;

    private int quantity;
}
