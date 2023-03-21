package com.macalicestore.entity;

import jakarta.persistence.*;

import java.sql.Date;

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

    private String postalСode;

    private String telephoneNumber;

//    @ManyToMany
//    private List<Listing> listings;

    private String status;
}
