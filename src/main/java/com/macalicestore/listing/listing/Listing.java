package com.macalicestore.listing.listing;

import com.macalicestore.listing.category.Category;
import com.macalicestore.listing.image.Image;
import com.macalicestore.listing.description.Description;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "listings")
@DiscriminatorColumn(name = "listing_type")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean isActive;

    //TODO Проверить CascadeType.MERGE
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Description description;

    private BigDecimal price;

    //TODO Проверить CascadeType.MERGE
    @ManyToMany(cascade = CascadeType.PERSIST)
    @OrderColumn
    private List<Image> images;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Category> categories;
}
