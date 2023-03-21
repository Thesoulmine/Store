package com.macalicestore.service;

import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Listing;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface ColourService {
    @Transactional
    void findColours(Set<Colour> colours, Listing listing);
}
