package com.macalicestore.listing.listing;

import com.macalicestore.listing.category.CategoryRepository;
import com.macalicestore.listing.category.CategoryService;
import com.macalicestore.listing.colour.ColourRepository;
import com.macalicestore.entity.*;
import com.macalicestore.listing.colour.ColourService;
import com.macalicestore.listing.description.DescriptionRepository;
import com.macalicestore.listing.description.DescriptionService;
import com.macalicestore.listing.material.Material;
import com.macalicestore.listing.material.MaterialRepository;
import com.macalicestore.listing.material.MaterialService;
import com.macalicestore.listing.size.SizeRepository;
import com.macalicestore.listing.image.ImageService;
import com.macalicestore.listing.size.SizeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;
    private final ColourService colourService;
    private final CategoryService categoryService;
    private final ImageService imageService;
    private final DescriptionService descriptionService;
    private final SizeService sizeService;
    private final MaterialService materialService;

    public ListingServiceImpl(ListingRepository listingRepository,
                              ColourService colourService,
                              CategoryService categoryService,
                              ImageService imageService,
                              DescriptionService descriptionService,
                              SizeService sizeService,
                              MaterialService materialService) {
        this.listingRepository = listingRepository;
        this.colourService = colourService;
        this.categoryService = categoryService;
        this.imageService = imageService;
        this.descriptionService = descriptionService;
        this.sizeService = sizeService;
        this.materialService = materialService;
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

    // TODO тесты на одновременное сохранение в нескольких тредах
    @Transactional
    @Override
    public void saveListing(Listing listing, String listingType, MultipartFile[] images) throws IOException {
        switch (listingType) {
            case "DIGITAL" -> saveDigitalListing(listing, images);
            case "PHYSICAL" -> savePhysicalListing(listing, images);
        }
    }

    private void saveDigitalListing(Listing listing, MultipartFile[] images) throws IOException {
        DigitalListing digitalListing = (DigitalListing) listing;

        digitalListing.setImages(
                imageService.findOrCreateImagesInDirectory(
                        images,
                        String.valueOf(digitalListing.getListingsGroup().getId())));
    }

    private void savePhysicalListing(Listing listing, MultipartFile[] images) throws IOException {
        PhysicalListing physicalListing = (PhysicalListing) listing;

        physicalListing.setColour(Objects.requireNonNullElse(
                colourService.findColourByNameOrElseNull(physicalListing.getColour().getName()),
                physicalListing.getColour()));

        physicalListing.setDescription(Objects.requireNonNullElse(
                descriptionService.findDescriptionByTextOrElseNull(physicalListing.getDescription().getText()),
                physicalListing.getDescription()));

        physicalListing.setMaterials(Objects.requireNonNullElse(
                materialService.findMaterialsByNames(physicalListing.getMaterials().stream().map(Material::getName).toList()),
                physicalListing.getMaterials()));

        physicalListing.setImages(
                imageService.findOrCreateImagesInDirectory(
                        images,
                        String.valueOf(physicalListing.getListingsGroup().getId())));

        listingRepository.save(listing);
    }
}
