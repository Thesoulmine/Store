package com.macalicestore.listing.listing;

import com.macalicestore.listing.listing.digital.DigitalListing;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Set;

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
    public ResponseEntity<Page<ListingDTO>> getAllListings(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) Integer page,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
            @RequestParam("order") String order) {
        return new ResponseEntity<>(
                listingService
                        .findAll(
                                new HashSet<>(Set.of(DigitalListing.class)),
                                PageRequest.of(page, limit, Sort.Direction.fromString(order)))
                        .map(listingMapper::toDTO),
                HttpStatus.OK);
    }

    @GetMapping("/listings/{listingId}")
    public ResponseEntity<ListingDTO> getListing(@PathVariable("listingId") Long listingId) {
        return new ResponseEntity<>(
                listingMapper.toDTO(
                        listingService.findById(listingId)),
                HttpStatus.OK);
    }

    @PostMapping(value = "/listings", consumes = "multipart/form-data")
    public ResponseEntity<ListingDTO> createNewListing(
            @RequestPart("listing")  SaveListingDTO saveListingDTO,
            @RequestPart("files") MultipartFile[] images) {
        return new ResponseEntity<>(
                listingMapper.toDTO(listingService.create(saveListingDTO)),
                HttpStatus.OK);
    }
}
