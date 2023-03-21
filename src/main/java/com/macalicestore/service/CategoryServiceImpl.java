package com.macalicestore.service;

import com.macalicestore.entity.Category;
import com.macalicestore.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
