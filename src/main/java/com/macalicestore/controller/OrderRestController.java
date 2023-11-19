package com.macalicestore.controller;

import com.macalicestore.entity.Order;
import com.macalicestore.service.OrderService;
import net.suuft.yookassa.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    //TODO Доделать заказы
    @PostMapping("")
    public ResponseEntity<Void> addOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/payment")
    public ResponseEntity<Void> getNotification(@RequestBody Payment payment) {
        System.out.println(payment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
