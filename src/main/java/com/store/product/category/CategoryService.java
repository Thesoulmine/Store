package com.store.product.category;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
    @Transactional
    List<Category> findAllCategories();

    @Transactional
    void saveCategory(Category category);

    @Transactional
    Category findCategoryById(Long id);
}
