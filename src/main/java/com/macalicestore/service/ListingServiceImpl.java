package com.macalicestore.service;

import com.macalicestore.dto.ListingDTO;
import com.macalicestore.entity.Category;
import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Listing;
import com.macalicestore.mapper.ListingMapper;
import com.macalicestore.repository.CategoryRepository;
import com.macalicestore.repository.ColourRepository;
import com.macalicestore.repository.ListingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    
    private final ColourRepository colourRepository;

    private final CategoryRepository categoryRepository;
    
    private final ImageService imageService;
    
    private final ListingMapper listingMapper;

    public ListingServiceImpl(ListingRepository listingRepository, ColourRepository colourRepository, CategoryRepository categoryRepository, ImageService imageService, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.colourRepository = colourRepository;
        this.categoryRepository = categoryRepository;
        this.imageService = imageService;
        this.listingMapper = listingMapper;
    }

    @Transactional
    @Override
    public List<Listing> findAllListings() {
        return listingRepository.findAll();
    }

    @Transactional
    @Override
    public Listing findListingById(Long id) {
        return listingRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void saveListing(ListingDTO listingDTO, MultipartFile[] files) throws IOException {
        Listing listing = listingMapper.toEntity(listingDTO);
//        listing.setColours(findColours(listing.getColours()));
        listing.setImages(imageService.findImages(files));
        listingRepository.save(listing);
    }

    //@Override
    public void saveDigitalProductListing(ListingDTO listingDTO, MultipartFile[] files) {

    }

    //@Override
    public void savePhysicalProductListing(ListingDTO listingDTO, MultipartFile[] files) {

    }

//    @Transactional
//    @Override
//    public void updateListing(ListingDTO listingDTO) {
//
//    }

    @Transactional
    @Override
    public List<Colour> findColours(List<Colour> colours) {
        List<Colour> newColoursList = new ArrayList<>();
        colours.forEach(colour -> {
            newColoursList.add(Objects.requireNonNullElse(
                    colourRepository.findByName(colour.getName()),
                    colour));
        });
        return newColoursList;
    }

    @Override
    public Colour findColourById(Long colourId) {
        return colourRepository.findById(colourId).get();
    }

    @Transactional
    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
