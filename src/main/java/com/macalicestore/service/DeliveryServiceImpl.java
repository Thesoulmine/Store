package com.macalicestore.service;

import com.macalicestore.delivery.DeliveryManager;
import com.macalicestore.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final Map<String, DeliveryManager> deliveryMap;

    public DeliveryServiceImpl(List<DeliveryManager> deliveries) {
        deliveryMap = deliveries.stream()
                .collect(Collectors.toMap(DeliveryManager::getDeliveryType, Function.identity()));
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
