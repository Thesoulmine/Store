package com.macalicestore.listing.listingsgroup;

import com.macalicestore.listing.image.Image;
import com.macalicestore.listing.image.ImageDTO;
import com.macalicestore.listing.listing.digital.DigitalListingDTO;
import com.macalicestore.listing.listing.physical.PhysicalListingDTO;
import lombok.Data;

import java.util.List;

@Data
public class ListingsGroupDTO {

    private Long id;

    private String title;

    private ImageDTO mainImage;

    private List<PhysicalListingDTO> physicalProductListings;

    private DigitalListingDTO digitalProductListing;

    private List<ImageDTO> images;
}
