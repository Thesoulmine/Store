package com.macalicestore.listing.listing;

import com.macalicestore.listing.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public abstract class ConcreteListingService<E extends Listing, D extends ListingDTO, S extends SaveListingDTO>
        extends AbstractListingService<E, D, S> {

    @Autowired
    protected ImageService imageService;

    @Autowired
    protected ListingMapper listingMapper;

    @Transactional
    @Override
    public Page<E> findAll(Pageable pageable) {
        return listingRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public E findById(Long id) {
        return listingRepository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public E create(S saveListingDTO) {
        E listing = listingMapper.toEntity(saveListingDTO);
        fillListing(listing, saveListingDTO);
        fillConcreteListing(listing, saveListingDTO);
        return listingRepository.save(listing);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        listingRepository.deleteById(id);
    }

    @Transactional
    @Override
    public E update(S saveListingDTO) {
        E listing = listingMapper.toEntity(saveListingDTO);
        fillListing(listing, saveListingDTO);
        fillConcreteListing(listing, saveListingDTO);
        return listingRepository.save(listing);
    }

    private void fillListing(E listing, S saveListingDTO) {
        listing.setImages(imageService.getAllById(saveListingDTO.getExistingImageIds()));
        saveListingDTO.getNewImages().stream()
                .map(image -> imageService.create(image, saveListingDTO.getId().toString()))
                .forEach(image -> listing.getImages().add(image));
    }

    public abstract Class<E> getEntityClass();

    public abstract Class<D> getDTOClass();

    public abstract Class<S> getSaveDTOClass();

    protected abstract void fillConcreteListing(E listing, S saveListingDTO);
}
