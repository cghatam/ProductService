package com.scalar.sample.controller;

import com.scalar.sample.model.Product;
import com.scalar.sample.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
    //public ProductController(@Qualifier("fakeProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                        @RequestParam("pageSize") int pageSize){
        return productService.getAllProducts(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        //return productService.getProductById(id);
        return productService.getProductByIdUsingStoredProc(id);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id,
                                                  @RequestHeader("auth") String token){
        return productService.getProductById(id, token);
    }*/

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping
    public Product updateProductByPatch(@PathVariable("id") Long id,
                                        @RequestBody Product product){
        return productService.updateProductUsingPatch(product);
    }

}
