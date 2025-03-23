package com.macalicestore.payment;

import java.math.BigDecimal;

public interface PaymentClient {

    void createPayment(BigDecimal cartTotalCost, BigDecimal deliveryCost);

    String getPaymentClientType();
}
