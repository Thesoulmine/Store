package com.macalicestore.listing.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class AbstractListingService<E extends Listing, D extends ListingDTO, S extends SaveListingDTO> {

    @Autowired
    protected ListingRepository<E> listingRepository;

    public abstract Page<E> findAll(Pageable pageable);

    public abstract E findById(Long id);

    public abstract E create(S listingDTO);

    public abstract void delete(Long id);

    public abstract E update(S listingDTO);
}
