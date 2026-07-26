package com.store.payment;

import com.store.product.cart.CartService;
import com.store.delivery.DeliveryService;
import com.store.delivery.DeliveryType;
import com.store.order.Order;
import com.store.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final OrderService orderService;
    private final CartService cartService;

    public PaymentRestController(
            PaymentService paymentService,
            DeliveryService deliveryService,
            OrderService orderService,
            CartService cartService) {
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/yookassaCreate")
    public ResponseEntity<String> createYookassaPayment(@RequestBody Order order) {
        DeliveryType deliveryType = DeliveryType.RUSSIAN_POST;
        PaymentType paymentType = PaymentType.YOOKASSA;
        deliveryService.processDelivery(deliveryType, order);
//        paymentService.createPayment(
//                paymentType, cartService.computeUserCartTotalCost(), deliveryService.getDeliveryCost(deliveryType, order));
        orderService.create(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
