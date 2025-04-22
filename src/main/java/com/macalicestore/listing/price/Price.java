package com.macalicestore.listing.price;

import com.macalicestore.listing.listing.Listing;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Data
@Entity
@Table(name = "titles")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal cost;

    @Column(name = "currency_code")
    @Convert(converter = CurrencyConverter.class)
    private Currency currency;

    @OneToMany(mappedBy = "mainPrice")
    private List<Listing> listings;
}
