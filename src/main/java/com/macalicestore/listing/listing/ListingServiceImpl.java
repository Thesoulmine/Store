package com.macalicestore.listing.listing;

import com.macalicestore.listing.image.ImageService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    private final Map<Class<? extends Listing>, ConcreteListingService> concreteListingServiceByListingClassMap;
    private final ImageService imageService;

    public ListingServiceImpl(List<ConcreteListingService> concreteListingServiceList,
                              ListingRepository listingRepository,
                              ImageService imageService) {
        this.concreteListingServiceByListingClassMap = new HashMap<>();
        concreteListingServiceList.forEach(concreteListingService ->
                concreteListingServiceByListingClassMap.put(
                        concreteListingService.getEntityClass(),
                        concreteListingService));
        this.listingRepository = listingRepository;
        this.imageService = imageService;
    }

    @Override
    public Page<Listing> findAllListings(Pageable pageable) {
        return listingRepository.findAll(pageable);
    }

    @Override
    public Page<Listing> findAllListings(Set<Class<? extends Listing>> listingClasses, Pageable pageable) {
        listingClasses.remove(Listing.class);
        return listingRepository.findAll(Example.of(), pageable);
    }

    @Override
    public Listing findListingById(Long id) {
        return listingRepository.findById(id).get();
    }

    @Override
    public Listing saveListing(Listing listing, MultipartFile[] images) {
        fillListing(listing, images);
        getConcreteListingService(listing).fillListing(listing, images);
        return listingRepository.save(listing);
    }

    @Override
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    @Override
    public Listing updateListing(Listing listing, MultipartFile[] images) {
        fillListing(listing, images);
        getConcreteListingService(listing).fillListing(listing, images);
        return listingRepository.save(listing);
    }

    private void fillListing(Listing listing, MultipartFile[] images) {

    }

    private ConcreteListingService getConcreteListingService(Listing listing) {
        return concreteListingServiceByListingClassMap.get(listing.getClass());
    }
}
