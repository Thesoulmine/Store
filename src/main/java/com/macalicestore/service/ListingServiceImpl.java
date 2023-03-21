package com.macalicestore.service;

import com.macalicestore.entity.Listing;
import com.macalicestore.repository.ListingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Transactional
    @Override
    public List<Listing> findAll() {
        List<Listing> listings = listingRepository.findAll();
//        listings.forEach(listing -> {
//            Hibernate.initialize(listing.getCategory());
//        });
        return listings;
    }

    @Transactional
    @Override
    public Listing findById(Long id) {
        return listingRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void save(Listing listing) {
        listingRepository.save(listing);
    }
}
