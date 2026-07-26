package com.store.order;

import com.store.base.BaseMapper;
import com.store.base.BaseRestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderRestController extends BaseRestController<Order, OrderDto> {

    public OrderRestController(OrderService service, BaseMapper<Order, OrderDto> mapper) {
        super(service, mapper);
    }
}
