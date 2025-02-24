package com.macalicestore.listing.listing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ListingController {

    private final ListingService listingService;

    private final ListingMapper listingMapper;

    public ListingController(ListingService listingService, ListingMapper listingMapper) {
        this.listingService = listingService;
        this.listingMapper = listingMapper;
    }

    @GetMapping("/listings")
    public ResponseEntity<List<ListingDTO>> getAllListings() {
        return new ResponseEntity<>(listingMapper.toDto(listingService.findAllListings()), HttpStatus.OK);
    }

    @GetMapping("/listings/{listingId}")
    public ResponseEntity<ListingDTO> getListing(@PathVariable("listingId") Long listingId) {
        return new ResponseEntity<>(listingMapper.toDTO(listingService.findListingById(listingId)), HttpStatus.OK);
    }

    @PostMapping(value = "/listings", consumes = "multipart/form-data")
    public ResponseEntity<Void> addNewListing(@RequestPart("listing")  ListingDTO listingDTO,
                                              @RequestPart("files") MultipartFile[] images) throws IOException {
        listingService.saveListing(listingMapper.toEntity(listingDTO), listingDTO.getListingType(), images);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
