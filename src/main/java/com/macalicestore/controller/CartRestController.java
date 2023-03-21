package com.macalicestore.controller;

import com.macalicestore.entity.Cart;
import com.macalicestore.entity.Listing;
import com.macalicestore.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final Cart cart;
    private final ListingService listingService;

    public CartRestController(Cart cart, ListingService listingService) {
        this.cart = cart;
        this.listingService = listingService;
    }

    @GetMapping("")
    public ResponseEntity<List<Listing>> getCart() {
        return new ResponseEntity<>(cart.getListings(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addToCart(@RequestBody Listing listing_id) {
        Listing listing = listingService.findById(listing_id.getId());
        cart.add(listing);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
