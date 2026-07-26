package com.store.product.price;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceDTO {

    private Long id;

    private BigDecimal value;

    private String currencyCode;
}