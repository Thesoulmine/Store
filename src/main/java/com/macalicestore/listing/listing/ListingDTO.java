package com.macalicestore.listing.listing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.macalicestore.listing.category.Category;
import com.macalicestore.listing.description.DescriptionDTO;
import com.macalicestore.listing.image.Image;
import com.macalicestore.listing.listing.digital.DigitalListingDTO;
import com.macalicestore.listing.listing.physical.PhysicalListingDTO;
import com.macalicestore.listing.title.TitleDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "listingType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DigitalListingDTO.class, name = "DIGITAL"),
        @JsonSubTypes.Type(value = PhysicalListingDTO.class, name = "PHYSICAL")
})
@Data
public class ListingDTO {

    private Long id;

    private TitleDTO title;

    private DescriptionDTO description;

    private boolean isActive;

    private BigDecimal price;

    private List<Image> images;

    private List<Category> categories;

    private String listingType;
}