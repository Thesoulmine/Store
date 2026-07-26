package com.store.product.cart.item;

import com.store.base.BaseJpaRepository;
import com.store.base.BaseRepository;
import com.store.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CartItemService extends BaseService<CartItem> {

    public CartItemService(BaseJpaRepository<CartItem, Long> repository) {
        super(repository);
    }
}
