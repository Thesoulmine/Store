package com.macalicestore.payment;

import net.suuft.yookassa.exception.BadRequestException;

import java.math.BigDecimal;

public interface PaymentManager {

    void createPayment(BigDecimal cartTotalCost, BigDecimal deliveryCost) throws BadRequestException;

    String getPaymentType();
}
