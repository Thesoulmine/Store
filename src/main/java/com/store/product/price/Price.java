package com.store.product.price;

import com.store.product.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;

    @Column(name = "currency_code")
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
