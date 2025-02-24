package com.macalicestore.listing.description;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "descriptions")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
}
