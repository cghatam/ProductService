package com.scalar.sample.exceptionhandler;

import com.scalar.sample.dto.ExceptionDto;
import com.scalar.sample.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> doSomething(){
        ExceptionDto ed = new ExceptionDto();
        ed.setMessage("Something went wrong");
        ed.setResolution("Do nothing ");

        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundEx(ProductNotFoundException pe){
        ExceptionDto ed = new ExceptionDto();
        ed.setMessage("Product not found for Id: " + pe.getId());

        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleAllErrors(Exception e){
        ExceptionDto ed = new ExceptionDto();
        ed.setMessage(e.getMessage());
        ed.setResolution("No action");
        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
