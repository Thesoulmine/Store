package com.macalicestore.controller;

import com.macalicestore.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    private final Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/cart")
    public String showCart(ModelMap model) {
        model.addAttribute("listings", cart.getListings());
        return "cart";
    }
}
