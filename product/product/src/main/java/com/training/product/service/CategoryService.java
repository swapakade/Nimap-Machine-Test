package com.training.product.service;

import com.training.product.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> getAllCategories(Pageable pageable);

    Optional<Category> getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category updatedCategory);

    void deleteCategory(Long id);
}