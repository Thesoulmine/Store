package com.macalicestore.repository;

import com.macalicestore.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourRepository extends JpaRepository<Colour, Long> {

    public Colour findByName(String name);
}
