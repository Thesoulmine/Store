package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "listings_groups")
public class ListingsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<PhysicalProductListing> physicalProductListings;

    @OneToOne
    private DigitalProductListing digitalProductListing;
}
