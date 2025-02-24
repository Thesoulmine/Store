package com.macalicestore.listing.colour;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColourServiceImpl implements ColourService {

    private final ColourRepository colourRepository;

    public ColourServiceImpl(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    @Override
    public Colour findColourById(Long colourId) {
        return colourRepository.findById(colourId).get();
    }

    @Transactional
    @Override
    public Colour findColourByNameOrElseNull(String name) {
        return colourRepository.findByName(name).orElse(null);
    }
}
