package com.macalicestore.cart;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@SessionScope
public class Cart {

    private List<CartProductDTO> products = new ArrayList<>();

    private Long sequenceNumber = 1L;
}
