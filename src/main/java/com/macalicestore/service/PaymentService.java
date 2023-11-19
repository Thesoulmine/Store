package com.macalicestore.service;

import net.suuft.yookassa.exception.BadRequestException;

import java.math.BigDecimal;

public interface PaymentService {

    void createPayment(String paymentType, BigDecimal cartTotalCost, BigDecimal deliveryCost) throws BadRequestException;
}
