package com.macalicestore.listing.listingsgroup;

import com.macalicestore.listing.listing.DigitalListing;
import com.macalicestore.listing.listing.PhysicalListing;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listings_groups")
public class ListingsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "physical_listing_id")
    private List<PhysicalListing> physicalListings;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "digital_listing_id")
    private DigitalListing digitalListing;
}
