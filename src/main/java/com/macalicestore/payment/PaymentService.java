package com.macalicestore.payment;

import java.math.BigDecimal;

public interface PaymentService {

    void createPayment(String paymentType, BigDecimal cartTotalCost, BigDecimal deliveryCost);
}
