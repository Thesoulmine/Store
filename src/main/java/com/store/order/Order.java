package com.store.order;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

    private boolean isPayed;
}
