package com.macalicestore.service;

import com.macalicestore.entity.CartProduct;
import com.macalicestore.entity.Order;
import com.macalicestore.entity.Product;
import com.macalicestore.repository.OrderRepository;
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

    public OrderServiceImpl(OrderRepository orderRepository, ListingService listingService, CartService cartService) {
        this.orderRepository = orderRepository;
        this.listingService = listingService;
        this.cartService = cartService;
    }

    @Transactional
    @Override
    public void createOrder(Order order) {
        List<Product> products = new ArrayList<>();
        List<CartProduct> cartProducts = cartService.getCart();

        for (CartProduct cartProduct : cartProducts) {
            Product product = new Product();
            product.setListing(listingService.findListingById(cartProduct.getListingId()));
            product.setColour(listingService.findColourById(cartProduct.getColourId()));
            product.setQuantity(cartProduct.getQuantity());
            products.add(product);
        }

        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }
}
