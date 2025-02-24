package com.macalicestore.listing.colour;

import org.springframework.transaction.annotation.Transactional;

public interface ColourService {

    Colour findColourById(Long colourId);

    @Transactional
    Colour findColourByNameOrElseNull(String name);
}
