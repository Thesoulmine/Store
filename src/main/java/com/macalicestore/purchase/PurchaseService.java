package com.macalicestore.purchase;

import com.macalicestore.order.Order;
import com.macalicestore.cart.EmptyCartException;

public interface PurchaseService {

    void makePurchase(String paymentType, String deliveryType, Order order) throws EmptyCartException;
}
