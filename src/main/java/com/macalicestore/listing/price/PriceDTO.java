package com.macalicestore.listing.price;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class PriceDTO {

    private Long id;

    private BigDecimal value;

    private String currencyCode;
}