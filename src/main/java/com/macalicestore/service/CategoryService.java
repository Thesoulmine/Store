package com.macalicestore.service;

import com.macalicestore.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
    @Transactional
    List<Category> findAll();

    @Transactional
    void save(Category category);

    @Transactional
    Category findById(Long id);
}
