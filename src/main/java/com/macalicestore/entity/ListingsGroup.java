package com.macalicestore.entity;

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
    private List<PhysicalListing> physicalListings;

    @OneToOne(cascade = CascadeType.PERSIST)
    private DigitalListing digitalListing;
}
