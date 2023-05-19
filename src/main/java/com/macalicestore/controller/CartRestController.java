package com.macalicestore.controller;

import com.macalicestore.dto.ProductDTO;
import com.macalicestore.entity.Cart;
import com.macalicestore.entity.Product;
import com.macalicestore.mapper.ProductMapper;
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

    private final ProductMapper productMapper;

    public CartRestController(Cart cart, ListingService listingService, ProductMapper productMapper) {
        this.cart = cart;
        this.listingService = listingService;
        this.productMapper = productMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getCart() {
        return new ResponseEntity<>(cart.getProducts(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addToCart(@RequestBody ProductDTO productDTO) {
        productDTO.setListing(listingService.findById(productDTO.getListing().getId()));
        cart.add(productMapper.toEntity(productDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
