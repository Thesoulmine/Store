package com.macalicestore.delivery;

import com.macalicestore.order.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final Map<String, DeliveryClient> deliveryMap;

    public DeliveryServiceImpl(List<DeliveryClient> deliveries) {
        deliveryMap = deliveries.stream()
                .collect(Collectors.toMap(DeliveryClient::getDeliveryType, Function.identity()));
    }

    @Override
    public BigDecimal getDeliveryCost(String deliveryType, Order order) {
        return deliveryMap.get(deliveryType).getDeliveryCost(order);
    }

    @Override
    public LocalDateTime getDeliveryTime(String deliveryType, Order order) {
        return deliveryMap.get(deliveryType).getDeliveryTime(order);
    }

    @Override
    public void processDelivery(String deliveryType, Order order) {
        deliveryMap.get(deliveryType).processDelivery(order);
    }

    @Override
    public void cancelDelivery(String deliveryType, Order order) {
        deliveryMap.get(deliveryType).cancelDelivery(order);
    }
}
