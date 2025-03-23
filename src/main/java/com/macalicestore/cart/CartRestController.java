package com.macalicestore.cart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("")
    public ResponseEntity<List<CartProductDTO>> getCart() {
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
