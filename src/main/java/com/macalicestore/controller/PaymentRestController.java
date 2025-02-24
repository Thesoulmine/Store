package com.macalicestore.controller;

import com.macalicestore.entity.Order;
import com.macalicestore.exception.EmptyCartException;
import com.macalicestore.exception.PaymentException;
import com.macalicestore.service.PurchaseService;
import net.suuft.yookassa.Yookassa;
import net.suuft.yookassa.exception.BadRequestException;
import net.suuft.yookassa.exception.UnspecifiedShopInformation;
import net.suuft.yookassa.model.Amount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;


@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    private final PurchaseService paymentService;

    public PaymentRestController(PurchaseService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/yookassaCreate")
    public ResponseEntity<String> createYookassaPayment(@RequestBody Order order) {
        try {
            paymentService.makePurchase("Yookassa", "RussianPost", order);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EmptyCartException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/succeeded")
    public void testSucceeded() {

    }
}
