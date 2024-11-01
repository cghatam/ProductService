package com.scalar.sample.service;


import com.scalar.sample.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<Product> getProductById(Long id);
    ResponseEntity<Product> getProductById(Long id, String token);

    List<Product> getAllProducts();

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product updateProduct(Product product);

    Product createProduct(Product product);


}
