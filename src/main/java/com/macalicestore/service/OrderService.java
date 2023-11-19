package com.macalicestore.service;

import com.macalicestore.entity.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {

    void createOrder(Order order);
}
