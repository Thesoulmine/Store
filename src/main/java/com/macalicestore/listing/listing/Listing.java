package com.macalicestore.listing.listing;

import com.macalicestore.listing.category.Category;
import com.macalicestore.listing.description.Description;
import com.macalicestore.listing.image.Image;
import com.macalicestore.listing.price.Price;
import com.macalicestore.listing.title.Title;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "listing_type")
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE})
    @JoinColumn(name = "title_id")
    private Title title;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE})
    @JoinColumn(name = "description_id")
    private Description description;

    private boolean isActive;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "main_price_id")
//    private Price mainPrice;
//
//    @OneToMany(mappedBy = "listing")
//    private List<Price> prices;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
    })
    @OrderColumn
    private List<Image> images;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "listings")
    private List<Category> categories;
}
