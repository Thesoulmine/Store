package com.store.payment;

import java.math.BigDecimal;

public interface PaymentService {

    void createPayment(PaymentType paymentType, BigDecimal cartTotalCost, BigDecimal deliveryCost);
}
