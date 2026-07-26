package com.store.product.product;

import com.store.product.category.Category;
import com.store.product.image.Image;
import com.store.product.price.Price;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean isActive;

    @OneToMany(mappedBy = "product")
    private List<Price> prices;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderColumn
    private List<Image> images;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "products")
    private List<Category> categories;
}
