package com.store.product.cart;

import com.store.product.cart.item.CartItem;
import com.store.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    private Long id;

    //private List<CartItem> products = new ArrayList<>();

    //private User user;
}
