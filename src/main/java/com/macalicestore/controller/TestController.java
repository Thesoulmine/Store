package com.macalicestore.controller;

import com.macalicestore.notification.message.mail.OrderCreatedMailMessageTemplate;
import com.macalicestore.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/test")
public class TestController {

    private final NotificationService notificationService;

    public TestController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("mail")
    public ResponseEntity<Void> testMail() {
        notificationService.sendEmailNotification("mohk223@gmail.com",
                new OrderCreatedMailMessageTemplate());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
