package com.macalicestore.listing.listingsgroup;

import com.macalicestore.listing.image.Image;
import com.macalicestore.listing.listing.digital.DigitalListing;
import com.macalicestore.listing.listing.physical.PhysicalListing;
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

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "listingsGroup")
    private List<PhysicalListing> physicalListings;

    @OneToOne(fetch = FetchType.LAZY)
    private DigitalListing digitalListing;
}
