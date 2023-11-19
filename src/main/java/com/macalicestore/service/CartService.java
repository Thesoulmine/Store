package com.macalicestore.service;

import com.macalicestore.entity.CartProduct;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    List<CartProduct> getCart();

    void clearCart();

    BigDecimal computeUserCartTotalCost();

    void addToCart(Long listingId, Long colourId);

    void deleteFromCart(Long productId);

    void updateCartProductQuantity(Long productId, int quantity);

    CartProduct findProductInCartBy(Long listingId, Long colourId);

    CartProduct findProductInCartBy(Long productId);
}
