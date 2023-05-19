package com.macalicestore.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;

    private String email;

    private String country;

    private String city;

    private String address;

    private String postalCode;

    private String telephoneNumber;

    @OneToMany
    private List<Product> products;

    private String status;
}
