package com.macalicestore.controller;

import com.macalicestore.dto.ProductDTO;
import com.macalicestore.entity.Cart;
import com.macalicestore.entity.CartProduct;
import com.macalicestore.entity.Order;
import com.macalicestore.entity.Product;
import com.macalicestore.mapper.ProductMapper;
import com.macalicestore.service.CartService;
import com.macalicestore.service.ListingService;
import com.macalicestore.service.OrderService;
import net.suuft.yookassa.Yookassa;
import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.model.Amount;
import net.suuft.yookassa.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public ResponseEntity<List<CartProduct>> getCart() {
        return new ResponseEntity<>(cartService.getCart(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addToCart(@RequestParam Long listingId, @RequestParam Long colourId) {
        cartService.addToCart(listingId, colourId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFromCart(@PathVariable("id") Long productId) {
        cartService.deleteFromCart(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<Void> updateCartProductQuantity(@PathVariable("id") Long productId,
                                                          @RequestPart("quantity") int quantity) {
        cartService.updateCartProductQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
