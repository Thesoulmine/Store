package com.macalicestore.listing.category;

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
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
