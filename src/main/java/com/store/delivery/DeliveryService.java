package com.store.delivery;

import com.store.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeliveryService {

    BigDecimal getDeliveryCost(DeliveryType deliveryType, Order order);

    LocalDateTime getDeliveryTime(DeliveryType deliveryType, Order order);

    void processDelivery(DeliveryType deliveryType, Order order);

    void cancelDelivery(DeliveryType deliveryType, Order order);
}
