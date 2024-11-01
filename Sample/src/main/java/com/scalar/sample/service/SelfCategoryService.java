package com.scalar.sample.service;

import com.scalar.sample.exception.CategoryNotFoundException;
import com.scalar.sample.model.Category;
import com.scalar.sample.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SelfCategoryService implements CategoryService{
    private CategoryRepository categoryRepository;

    public ResponseEntity<Category> getCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new CategoryNotFoundException(id);
        }
        ResponseEntity<Category> response;
        response = new ResponseEntity<>(category.get(), HttpStatus.OK);
        return response;
    }

    public ResponseEntity<Category> createCategory(Category category){
        category = categoryRepository.save(category);
        ResponseEntity<Category> response;
        response = new ResponseEntity<>(category, HttpStatus.OK);
        return response;
    }
}
