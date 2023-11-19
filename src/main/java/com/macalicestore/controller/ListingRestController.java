package com.macalicestore.controller;

import com.macalicestore.dto.ListingDTO;
import com.macalicestore.entity.Listing;
import com.macalicestore.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingRestController {

    private final ListingService listingService;

    public ListingRestController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("")
    public ResponseEntity<List<Listing>> getAllListings() {
        return new ResponseEntity<>(listingService.findAllListings(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Listing> getListing(@PathVariable("id") Long id) {
        return new ResponseEntity<>(listingService.findListingById(id), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "multipart/form-data")
    public ResponseEntity<Void> addNewListing(@RequestPart("listing") ListingDTO listingDTO,
                                              @RequestPart("files") MultipartFile[] files) throws IOException {
        listingService.saveListing(listingDTO, files);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
