package com.macalicestore.payment;

import com.macalicestore.order.Order;
import com.macalicestore.cart.EmptyCartException;
import com.macalicestore.purchase.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        } catch (EmptyCartException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/succeeded")
    public void testSucceeded() {

    }
}
