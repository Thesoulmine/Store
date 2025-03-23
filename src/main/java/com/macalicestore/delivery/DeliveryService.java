package com.macalicestore.delivery;

import com.macalicestore.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeliveryService {

    BigDecimal getDeliveryCost(String deliveryType, Order order);

    LocalDateTime getDeliveryTime(String deliveryType, Order order);

    void processDelivery(String deliveryType, Order order);

    void cancelDelivery(String deliveryType, Order order);
}
