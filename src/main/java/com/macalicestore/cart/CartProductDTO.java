package com.macalicestore.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductDTO {

    private Long id;

    private Long listingId;

    private Long colourId;

    private BigDecimal listingPrice;

    private int quantity;
}
