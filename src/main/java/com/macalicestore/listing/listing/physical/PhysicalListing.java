package com.macalicestore.listing.listing.physical;

import com.macalicestore.listing.listing.Listing;
import com.macalicestore.listing.listingsgroup.ListingsGroup;
import com.macalicestore.listing.colour.Colour;
import com.macalicestore.listing.material.Material;
import com.macalicestore.listing.size.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "physical_listings")
@DiscriminatorValue("physical_listing")
public class PhysicalListing extends Listing {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_group_id")
    private ListingsGroup listingsGroup;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Material> materials;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "colour_id")
    private Colour colour;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Size> sizes;
}
