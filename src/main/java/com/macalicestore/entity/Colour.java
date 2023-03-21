package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "colours")
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Colour() {

    }

    public Colour(String name) {
        this.name = name;
    }
}
