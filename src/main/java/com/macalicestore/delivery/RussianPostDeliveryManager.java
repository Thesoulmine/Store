package com.macalicestore.delivery;

import com.macalicestore.entity.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class RussianPostDeliveryManager implements DeliveryManager {

    private final String applicationAuthorizationToken = "EhiaMc_9mFDc4uTO0XJjChTSkSj3cpGr";

    private final String userAuthorizationToken = "bW9oazIyM0BnbWFpbC5jb206TW9oa3UyMjMx";

    @Override
    public BigDecimal getDeliveryCost(Order order) {
        return BigDecimal.ZERO;
    }

    @Override
    public LocalDateTime getDeliveryTime(Order order) {
        return LocalDateTime.now();
    }

    @Override
    public void processDelivery(Order order) {
    }

    @Override
    public void cancelDelivery(Order order) {

    }

    @Override
    public String getDeliveryType() {
        return "RussianPost";
    }
}
