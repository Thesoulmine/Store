package com.store.product.cart;

import com.store.base.BaseJpaRepository;
import com.store.base.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService extends BaseService<Cart> {

    private final CartCookieRepository cartCookieRepository;

    public CartService(BaseJpaRepository<Cart, Long> repository, CartCookieRepository cartCookieRepository) {
        super(repository);
        this.cartCookieRepository = cartCookieRepository;
    }

    @Override
    public List<Cart> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }

    @Override
    public Cart getById(Long id) {
        return super.getById(id);
    }

    @Override
    public Cart create(Cart entity) {
        return super.create(entity);
    }

    @Override
    public void removeById(Long id) {
        super.removeById(id);
    }

//    public Cart getByUserId(Long id) {
//
//    }
}
