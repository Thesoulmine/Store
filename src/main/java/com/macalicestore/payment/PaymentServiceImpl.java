package com.macalicestore.payment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Map<String, PaymentClient> paymentMap;

    public PaymentServiceImpl(List<PaymentClient> paymentClients) {
        paymentMap = paymentClients.stream()
                .collect(Collectors.toMap(PaymentClient::getPaymentClientType, Function.identity()));
    }

    @Override
    public void createPayment(String paymentType, BigDecimal cartTotalCost, BigDecimal deliveryCost) {
        paymentMap.get(paymentType).createPayment(cartTotalCost, deliveryCost);
    }
}
