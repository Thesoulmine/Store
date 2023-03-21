package com.macalicestore.service;

import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Listing;
import com.macalicestore.repository.ColourRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class ColourServiceImpl implements ColourService {

    private final ColourRepository colourRepository;

    public ColourServiceImpl(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Transactional
    @Override
    public void findColours(Set<Colour> colours, Listing listing) {
        Set<Colour> newColourSet = new HashSet<>();
        colours.forEach(colour -> {
            newColourSet.add(Objects.requireNonNullElse(
                    colourRepository.findByName(colour.getName()),
                    colour));
        });
        listing.setColours(newColourSet);
    }
}
