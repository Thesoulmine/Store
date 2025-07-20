package com.macalicestore.cart;

import com.macalicestore.listing.listing.ListingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final Cart cart;

    private final ListingService listingService;

    public CartServiceImpl(Cart cart, ListingService listingService) {
        this.cart = cart;
        this.listingService = listingService;
    }

    @Override
    public List<CartProductDTO> getCart() {
        return cart.getProducts();
    }

    @Override
    public void clearCart() {
        cart.getProducts().clear();
    }

    @Override
    public BigDecimal computeUserCartTotalCost() {
        BigDecimal cartTotalCost = BigDecimal.ZERO;

        for (CartProductDTO product : getCart()) {
            cartTotalCost = cartTotalCost.add(product.getListingPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
        }

        return cartTotalCost;
    }

    @Override
    public void addToCart(Long listingId, Long colourId) {
        CartProductDTO foundProduct = findProductInCartBy(listingId, colourId);

        if (foundProduct == null) {
            CartProductDTO product = new CartProductDTO();
            product.setId(cart.getSequenceNumber());
            product.setListingId(listingId);
            product.setColourId(colourId);
            //product.setListingPrice(listingService.findListingById(listingId).getPrice());
            product.setQuantity(1);
            cart.setSequenceNumber(cart.getSequenceNumber() + 1);
            cart.getProducts().add(product);
        } else {
            foundProduct.setQuantity(foundProduct.getQuantity() + 1);
        }
    }

    @Override
    public void deleteFromCart(Long productId) {
        Iterator<CartProductDTO> iterator = cart.getProducts().iterator();

        while (iterator.hasNext()) {
            CartProductDTO product = iterator.next();
            if (product.getId().equals(productId)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public void updateCartProductQuantity(Long productId, int quantity) {
        CartProductDTO foundProduct = findProductInCartBy(productId);
        foundProduct.setQuantity(quantity);
    }

    @Override
    public CartProductDTO findProductInCartBy(Long listingId, Long colourId) {
        return cart.getProducts().stream()
                .filter(product -> product.getListingId().equals(listingId) &&
                        product.getColourId().equals(colourId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CartProductDTO findProductInCartBy(Long productId) {
        return cart.getProducts().stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
