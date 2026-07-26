package com.store.delivery;

import com.store.order.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final Map<DeliveryType, DeliveryClient> deliveryMap;

    public DeliveryServiceImpl(List<DeliveryClient> deliveries) {
        deliveryMap = deliveries.stream().collect(Collectors.toMap(DeliveryClient::getDeliveryType, Function.identity()));
    }

    @Override
    public BigDecimal getDeliveryCost(DeliveryType deliveryType, Order order) {
        return deliveryMap.get(deliveryType).getDeliveryCost(order);
    }

    @Override
    public LocalDateTime getDeliveryTime(DeliveryType deliveryType, Order order) {
        return deliveryMap.get(deliveryType).getDeliveryTime(order);
    }

    @Override
    public void processDelivery(DeliveryType deliveryType, Order order) {
        deliveryMap.get(deliveryType).processDelivery(order);
    }

    @Override
    public void cancelDelivery(DeliveryType deliveryType, Order order) {
        deliveryMap.get(deliveryType).cancelDelivery(order);
    }
}
