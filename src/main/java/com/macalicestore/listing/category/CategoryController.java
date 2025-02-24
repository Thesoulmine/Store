package com.macalicestore.listing.category;

import com.macalicestore.listing.listing.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
