package com.store.order;

import com.store.base.BaseJpaRepository;
import com.store.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService extends BaseService<Order> {

    public OrderService(BaseJpaRepository<Order, Long> repository) {
        super(repository);
    }

    @Override
    public Order create(Order order) {
        order.setOrderDate(LocalDateTime.now());
        return dbRepository.save(order);
    }
}
