package com.macalicestore.payment;

import net.suuft.yookassa.Yookassa;
import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.model.Amount;
import net.suuft.yookassa.model.Payment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class YookassaPaymentManager implements PaymentManager {

    private final Yookassa yookassa;

    public YookassaPaymentManager(Yookassa yookassa) {
        this.yookassa = yookassa;
    }

    @Override
    public void createPayment(BigDecimal cartTotalCost, BigDecimal deliveryCost) throws BadRequestException {
        try {
            Payment payment = yookassa.createPayment(
                    new Amount(cartTotalCost.add(deliveryCost), "RUB"),
                    "Оплата",
                    "http://localhost:8080");
            System.out.println(payment.confirmation.confirmation_url);
        } catch (UnspecifiedShopInformation | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPaymentType() {
        return "Yookassa";
    }
}
