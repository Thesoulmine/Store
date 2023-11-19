package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pattern_listings")
@DiscriminatorValue("pattern_listing")
public class DigitalProductListing extends Listing {

    @OneToOne
    private ListingsGroup listingsGroup;
}
