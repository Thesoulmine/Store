package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "physical_product_listings")
@DiscriminatorValue("physical_product_listing")
public class PhysicalProductListing extends Listing {

    private String material;

    @ManyToOne
    private ListingsGroup listingsGroup;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Colour> colours;
}
