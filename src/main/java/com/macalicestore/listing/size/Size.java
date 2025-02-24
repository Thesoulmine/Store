package com.macalicestore.listing.size;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String euSizeName;

    private String ruSizeName;
}
