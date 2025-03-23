package com.macalicestore.order;

import com.macalicestore.cart.CartProductDTO;
import com.macalicestore.cart.CartService;
import com.macalicestore.purchase.Product;
import com.macalicestore.listing.colour.ColourService;
import com.macalicestore.listing.listing.ListingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ListingService listingService;
    private final CartService cartService;
    private final ColourService colourService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ListingService listingService,
                            CartService cartService,
                            ColourService colourService) {
        this.orderRepository = orderRepository;
        this.listingService = listingService;
        this.cartService = cartService;
        this.colourService = colourService;
    }

    @Transactional
    @Override
    public void createOrder(Order order) {
        List<Product> products = new ArrayList<>();
        List<CartProductDTO> cartProductDTOS = cartService.getCart();

        for (CartProductDTO cartProductDTO : cartProductDTOS) {
            Product product = new Product();
            product.setListing(listingService.findListingById(cartProductDTO.getListingId()));
            product.setColour(colourService.findColourById(cartProductDTO.getColourId()));
            product.setQuantity(cartProductDTO.getQuantity());
            products.add(product);
        }

        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }
}
