package com.store.product.cart;

import com.store.base.BaseMapper;
import com.store.base.BaseRestController;
import com.store.base.BaseService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cart")
public class CartRestController extends BaseRestController<Cart, CartDTO> {

    public CartRestController(CartService service, BaseMapper<Cart, CartDTO> mapper) {
        super(service, mapper);
    }
}
