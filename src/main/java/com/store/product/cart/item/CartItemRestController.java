package com.store.product.cart.item;

import com.store.base.BaseMapper;
import com.store.base.BaseRestController;
import com.store.base.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts/items")
public class CartItemRestController extends BaseRestController<CartItem, CartItemDTO> {

    public CartItemRestController(CartItemService service, CartItemMapper mapper) {
        super(service, mapper);
    }
}
