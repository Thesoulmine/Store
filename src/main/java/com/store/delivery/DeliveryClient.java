package com.store.delivery;

import com.store.order.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeliveryClient {

    BigDecimal getDeliveryCost(Order order);

    LocalDateTime getDeliveryTime(Order order);

    void processDelivery(Order order);

    void cancelDelivery(Order order);

    DeliveryType getDeliveryType();
}
