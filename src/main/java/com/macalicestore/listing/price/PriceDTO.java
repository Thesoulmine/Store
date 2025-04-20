package com.macalicestore.listing.price;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceDTO {

    private Long id;

    private BigDecimal rub;

    private BigDecimal eur;

    private BigDecimal usd;
}