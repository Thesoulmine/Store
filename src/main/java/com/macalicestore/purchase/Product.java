package com.macalicestore.purchase;

import com.macalicestore.listing.listing.Listing;
import com.macalicestore.listing.colour.Colour;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Listing listing;

    @OneToOne
    private Colour colour;

    private int quantity;
}
