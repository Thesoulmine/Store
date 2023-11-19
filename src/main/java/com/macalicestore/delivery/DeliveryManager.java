package com.macalicestore.delivery;

import com.macalicestore.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeliveryManager {

    BigDecimal getDeliveryCost(Order order);

    LocalDateTime getDeliveryTime(Order order);

    void processDelivery(Order order);

    void cancelDelivery(Order order);

    String getDeliveryType();
}
