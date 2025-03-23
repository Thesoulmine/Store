package com.macalicestore.cart;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    List<CartProductDTO> getCart();

    void clearCart();

    BigDecimal computeUserCartTotalCost();

    void addToCart(Long listingId, Long colourId);

    void deleteFromCart(Long productId);

    void updateCartProductQuantity(Long productId, int quantity);

    CartProductDTO findProductInCartBy(Long listingId, Long colourId);

    CartProductDTO findProductInCartBy(Long productId);
}
