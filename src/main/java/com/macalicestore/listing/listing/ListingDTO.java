package com.macalicestore.listing.listing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.macalicestore.listing.category.Category;
import com.macalicestore.listing.description.Description;
import com.macalicestore.listing.image.Image;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.Data;
import org.mapstruct.Mapper;

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
@Schema(subTypes = {DigitalListingDTO.class, PhysicalListingDTO.class})
@Data
@Mapper
public class ListingDTO {

    private Long id;

    private String title;

    private boolean isActive;

    @Column(length = 65535)
    private Description description;

    private BigDecimal price;

    private List<Image> images;

    private List<Category> categories;

    private String listingType;
}