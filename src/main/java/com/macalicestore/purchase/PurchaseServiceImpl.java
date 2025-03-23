package com.macalicestore.purchase;

import com.macalicestore.cart.CartService;
import com.macalicestore.delivery.DeliveryService;
import com.macalicestore.order.Order;
import com.macalicestore.cart.EmptyCartException;
import com.macalicestore.order.OrderService;
import com.macalicestore.payment.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final OrderService orderService;

    private final PaymentService paymentService;

    private final CartService cartService;

    private final DeliveryService deliveryService;

    public PurchaseServiceImpl(OrderService orderService, PaymentService paymentService, CartService cartService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.deliveryService = deliveryService;
    }

    @Override
    public void makePurchase(String paymentType, String deliveryType, Order order) throws EmptyCartException {
        BigDecimal userCartTotalCost = cartService.computeUserCartTotalCost();

        if (userCartTotalCost.equals(BigDecimal.ZERO)) {
            throw new EmptyCartException();
        }

        deliveryService.processDelivery(deliveryType, order);
        paymentService.createPayment(paymentType, userCartTotalCost,
                deliveryService.getDeliveryCost(deliveryType, order));
        orderService.createOrder(order);
    }
}
