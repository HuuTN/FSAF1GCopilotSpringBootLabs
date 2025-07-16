package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.CategoryDTO;
import com.example.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(CategoryDTO categoryDTO);
    Optional<Category> updateCategory(Long id, CategoryDTO categoryDTO);
    boolean deleteCategory(Long id);
}
