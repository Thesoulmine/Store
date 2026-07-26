package com.store.product.cart;

import com.store.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import tools.jackson.databind.ObjectMapper;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CartCookieRepository implements BaseRepository<Cart, UUID> {

    private final static String CART_COOKIE_NAME = "cart";
    private final ObjectMapper objectMapper;

    public CartCookieRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return null;
//                RequestContextHolder.getRequestAttributes().getAttribute(CART_COOKIE_NAME, RequestAttributes.SCOPE_REQUEST);
    }

    @Override
    public Optional<Cart> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public <S extends Cart> S save(S entity) {
        return null;
//                RequestContextHolder.getRequestAttributes().setAttribute(CART_COOKIE_NAME, RequestAttributes.SCOPE_REQUEST);
    }

    @Override
    public void deleteById(UUID id) {
        Cart cart = (Cart) RequestContextHolder.getRequestAttributes().getAttribute(CART_COOKIE_NAME, RequestAttributes.SCOPE_REQUEST);
        //cart.getProducts().removeIf(uuid -> uuid.equals(id));
        RequestContextHolder.getRequestAttributes().setAttribute(CART_COOKIE_NAME, cart, RequestAttributes.SCOPE_REQUEST);
    }

    public void deleteAll() {
        RequestContextHolder.getRequestAttributes().removeAttribute(CART_COOKIE_NAME, RequestAttributes.SCOPE_REQUEST);
    }
}
