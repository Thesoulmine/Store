package com.macalicestore.service;

import com.macalicestore.dto.ListingDTO;
import com.macalicestore.entity.Category;
import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Listing;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ListingService {

    List<Listing> findAllListings();

    Listing findListingById(Long id);

    void saveListing(ListingDTO listingDTO, MultipartFile[] files) throws IOException;

    List<Colour> findColours(List<Colour> colours);

    Colour findColourById(Long colourId);

    List<Category> findAllCategories();

    void saveCategory(Category category);

    Category findCategoryById(Long id);
}
