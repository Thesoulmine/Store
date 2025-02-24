package com.macalicestore.listing.colour;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColourRepository extends JpaRepository<Colour, Long> {

    Optional<Colour> findByName(String name);
}
