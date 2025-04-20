package com.macalicestore.listing.colour;

import com.macalicestore.listing.listing.physical.PhysicalListing;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "colours")
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "colour")
    private List<PhysicalListing> physicalListings;
}
