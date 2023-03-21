package com.macalicestore.service;

import com.macalicestore.entity.Listing;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ListingService {
    @Transactional
    List<Listing> findAll();

    @Transactional
    Listing findById(Long id);

    @Transactional
    void save(Listing listing);


}
