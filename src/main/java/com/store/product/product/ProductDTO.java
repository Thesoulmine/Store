package com.store.product.product;

import com.store.product.category.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {

    private Long id;

    private String title;

    private String description;

    private boolean isActive;

    private BigDecimal price;

    private List<Category> categories;
}