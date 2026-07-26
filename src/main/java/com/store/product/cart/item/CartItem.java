package com.store.product.cart.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CartItem {

    @Id
    private Long id;
}
