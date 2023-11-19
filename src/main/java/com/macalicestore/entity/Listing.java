package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "listings")
@DiscriminatorColumn(name = "listing_type")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 65535)
    private String description;

    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @OrderColumn
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinColumn(name="category_id")
    private Category category;
}
