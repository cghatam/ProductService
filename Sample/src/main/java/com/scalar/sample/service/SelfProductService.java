package com.scalar.sample.service;

import com.scalar.sample.commons.AuthCommon;
import com.scalar.sample.dto.UserDto;
import com.scalar.sample.exception.ProductNotFoundException;
import com.scalar.sample.model.Product;
import com.scalar.sample.repositories.CategoryRepository;
import com.scalar.sample.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AuthCommon authCommon;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository, AuthCommon authCommon){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.authCommon = authCommon;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        ResponseEntity<Product> response;

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id);
        }

        response = new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        return response;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id, String tokenValue) {
        ResponseEntity<Product> response;
        //Validate token
        UserDto userDto = authCommon.validateToken(tokenValue);

        if(userDto == null){
            response = new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }else{
            Optional<Product> optionalProduct = productRepository.findById(id);

            if(optionalProduct.isEmpty()){
                throw new ProductNotFoundException(id);
            }

            response = new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Product updateProduct(Product p) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        //Category category = product.getCategory();

        /*if(category.getTitle() != null){
            Category existingCategory = categoryRepository.findByTitle(category.getTitle());
            if(existingCategory == null){
                category = categoryRepository.save(category);
            }else{
                category = existingCategory;
            }
        }*/

        /*if (category.getId() == null) {
            //we need to save the category
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        } else {
            //we should check if the category id is valid or not.
        }*/

        Product savedProduct =  productRepository.save(product);
        //Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        //Category category1 = optionalCategory.get();
        //savedProduct.setCategory(category1);

        return savedProduct;
    }

    @Override
    public Product updateProductUsingPatch(Product product) {

        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<Product> getProductByIdUsingStoredProc(Long id){
        ResponseEntity<Product> response;
        Product product = productRepository.getProductById(id);
        response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;

    }
}
