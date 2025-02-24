package com.macalicestore.listing.category;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//    private Set<Listing> listings = new HashSet<>();
}
