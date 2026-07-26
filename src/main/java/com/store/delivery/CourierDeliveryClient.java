package com.store.delivery;

import com.store.order.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class CourierDeliveryClient implements DeliveryClient {

    @Override
    public BigDecimal getDeliveryCost(Order order) {
        return BigDecimal.ZERO;
    }

    @Override
    public LocalDateTime getDeliveryTime(Order order) {
        return LocalDateTime.now();
    }

    @Override
    public void processDelivery(Order order) {

    }

    @Override
    public void cancelDelivery(Order order) {

    }

    @Override
    public DeliveryType getDeliveryType() {
        return DeliveryType.COURIER;
    }
}
