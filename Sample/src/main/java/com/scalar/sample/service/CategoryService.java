package com.scalar.sample.service;

import com.scalar.sample.model.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    public ResponseEntity<Category> getCategory(Long id);
    public ResponseEntity<Category> createCategory(Category category);
}
