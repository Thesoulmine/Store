package com.macalicestore.listing.listing;

import com.macalicestore.listing.colour.Colour;
import com.macalicestore.listing.material.Material;
import com.macalicestore.listing.size.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhysicalListingDTO extends ListingDTO {

    private List<Material> materials;

    private List<Size> sizes;

    private Colour colour;
}
