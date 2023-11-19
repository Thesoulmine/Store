package com.macalicestore.service;

import com.macalicestore.entity.Order;
import com.macalicestore.exception.EmptyCartException;
import com.macalicestore.exception.PaymentException;
import net.suuft.yookassa.exception.BadRequestException;

public interface PurchaseService {

    void makePurchase(String paymentType, String deliveryType, Order order) throws BadRequestException, EmptyCartException;
}
