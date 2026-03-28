package com.macalicestore.order;

import com.macalicestore.purchase.Purchase;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private String email;

    private String country;

    private String city;

    private String address;

    private String postalCode;

    private String telephoneNumber;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "product_id")
    private List<Purchase> purchases;

    private boolean isPayed;
}
