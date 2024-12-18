package com.scalar.sample.service;


import com.scalar.sample.dto.FakeStoreProductDto;
import com.scalar.sample.exception.ProductNotFoundException;
import com.scalar.sample.model.Category;
import com.scalar.sample.model.Product;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service("fakeProductService")
public class FakeStoreProductService implements ProductService{
    private final RestTemplate restTemplate;
    //private RedisTemplate<String, Object> redisTemplate;
    private static final String FAKE_STORE_PRODUCT_URL = "https://fakestoreapi.com/products/";

    //@Autowired
    public FakeStoreProductService(RestTemplate restTemplate//,
                                   //RedisTemplate<String, Object> redisTemplate
    ){
        this.restTemplate = restTemplate;
        //this.redisTemplate = redisTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        //Category category = new Category(1L, fakeStoreProductDto.getCategory());
        //product.setCategory(category);
        return product;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {

        ResponseEntity<Product> responseEntity1 ;
        Product p =  null;
        //Product p = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT" + id);

        if (p==null){
            FakeStoreProductDto fakeStoreProductDto =
                    restTemplate.getForObject(FAKE_STORE_PRODUCT_URL+ id, FakeStoreProductDto.class);

            ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(FAKE_STORE_PRODUCT_URL+ id, FakeStoreProductDto.class);

            if (fakeStoreProductDto == null){
                throw new ProductNotFoundException(id);
                //responseEntity1 = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else{
                p = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
                //redisTemplate.opsForHash().put("PRODUCTS","PRODUCT" + id,p);
            }
        }

        responseEntity1 = new ResponseEntity<>(p,HttpStatus.OK) ;

        return responseEntity1;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id, String token) {
        return null;
    }

    private List<Product> convertFakeStoreProductsToProducts(FakeStoreProductDto[] fakeStoreProductDtoList){
        List<Product> products = new LinkedList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtoList){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public List<Product> getAllProducts() {
//        ResponseEntity<FakeStoreProductDto[]> responseEntity =
//                restTemplate.getForEntity(FAKE_STORE_PRODUCT_URL, FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject(FAKE_STORE_PRODUCT_URL,FakeStoreProductDto[].class );
        return convertFakeStoreProductsToProducts(fakeStoreProductDtos);//  (responseEntity.getBody());
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products?limit="+pageSize,FakeStoreProductDto[].class );
        List<Product> products =  convertFakeStoreProductsToProducts(fakeStoreProductDtos);//  (responseEntity.getBody());

        Page<Product> page = new PageImpl<>(products);

        return page;
    }

    @Override
    public Product createProduct(Product p){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        //fakeStoreProductDto.setId(p.getId());
        fakeStoreProductDto.setTitle(p.getTitle());
        fakeStoreProductDto.setDescription(p.getDescription());
        fakeStoreProductDto.setPrice(p.getPrice());
        fakeStoreProductDto.setImageUrl(p.getImageUrl());
        fakeStoreProductDto.setCategory(p.getCategory().getTitle());
        FakeStoreProductDto savedProduct = restTemplate.postForObject(FAKE_STORE_PRODUCT_URL,fakeStoreProductDto, FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(savedProduct);
    }

    @Override
    public Product updateProductUsingPatch(Product product) {

        return null;
    }

    @Override
    public ResponseEntity<Product>  getProductByIdUsingStoredProc(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Product p) {
        Long id = p.getId();
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(p.getId());
        fakeStoreProductDto.setTitle(p.getTitle());
        fakeStoreProductDto.setDescription(p.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        fakeStoreProductDto = restTemplate.execute(FAKE_STORE_PRODUCT_URL+ id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

}
