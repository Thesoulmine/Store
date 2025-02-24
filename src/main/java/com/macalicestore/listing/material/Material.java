package com.macalicestore.listing.material;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}