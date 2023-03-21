package com.macalicestore.controller;

import com.macalicestore.entity.Listing;
import com.macalicestore.service.ColourService;
import com.macalicestore.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingRestController {

    private final ListingService listingService;
    private final ColourService colourService;

    public ListingRestController(ListingService listingService, ColourService colourService) {
        this.listingService = listingService;
        this.colourService = colourService;
    }

    @GetMapping("")
    public ResponseEntity<List<Listing>> getAllListings() {
        return new ResponseEntity<>(listingService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Listing> getListing(@PathVariable("id") Long id) {
        return new ResponseEntity<>(listingService.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addNewListing(@RequestBody Listing listing) {
        colourService.findColours(listing.getColours(), listing);
        listingService.save(listing);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
