package com.macalicestore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProduct {

    private Long id;

    private Long listingId;

    private Long colourId;

    private BigDecimal listingPrice;

    private int quantity;
}
