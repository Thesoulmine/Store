package com.macalicestore.controller;

import com.macalicestore.entity.Category;
import com.macalicestore.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings/categories")
public class CategoryRestController {

    private final ListingService listingService;

    public CategoryRestController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(listingService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
        listingService.saveCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
