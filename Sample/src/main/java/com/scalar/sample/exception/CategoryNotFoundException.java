package com.scalar.sample.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(){
        super();
    }

    public CategoryNotFoundException(Long id){
        super("No category exist with id: " + id);
    }

}
