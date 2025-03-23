package com.macalicestore.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class YookassaPaymentClient implements PaymentClient {

    public YookassaPaymentClient() {
    }

    @Override
    public void createPayment(BigDecimal cartTotalCost, BigDecimal deliveryCost) {

    }

    @Override
    public String getPaymentClientType() {
        return "Yookassa";
    }
}
