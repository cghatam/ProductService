package com.scalar.sample.controller;

import com.scalar.sample.model.Category;
import com.scalar.sample.service.CategoryService;
import com.scalar.sample.service.SelfCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
