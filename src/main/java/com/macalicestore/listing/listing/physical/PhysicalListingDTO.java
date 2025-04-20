package com.macalicestore.listing.listing.physical;

import com.macalicestore.listing.colour.ColourDTO;
import com.macalicestore.listing.listing.ListingDTO;
import com.macalicestore.listing.material.MaterialDTO;
import com.macalicestore.listing.size.SizeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhysicalListingDTO extends ListingDTO {

    private List<MaterialDTO> materials;

    private ColourDTO colour;

    private List<SizeDTO> sizes;
}
