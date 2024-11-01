package com.scalar.sample.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {
    private Long id ;
    public ProductNotFoundException(Long id) {
        super();
        this.id = id;
    }
}
