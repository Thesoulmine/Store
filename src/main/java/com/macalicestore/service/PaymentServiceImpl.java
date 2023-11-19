package com.macalicestore.service;

import com.macalicestore.payment.PaymentManager;
import net.suuft.yookassa.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Map<String, PaymentManager> paymentMap;

    public PaymentServiceImpl(List<PaymentManager> paymentManagers) {
        paymentMap = paymentManagers.stream()
                .collect(Collectors.toMap(PaymentManager::getPaymentType, Function.identity()));
    }

    @Override
    public void createPayment(String paymentType, BigDecimal cartTotalCost, BigDecimal deliveryCost) throws BadRequestException {
        paymentMap.get(paymentType).createPayment(cartTotalCost, deliveryCost);
    }
}
