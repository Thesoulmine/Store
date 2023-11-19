package com.macalicestore.entity;

import com.macalicestore.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@SessionScope
public class Cart {

    private List<CartProduct> products = new ArrayList<>();

    private Long sequenceNumber = 1L;
}
