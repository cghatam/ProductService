package com.scalar.sample.exceptionhandler;

import com.scalar.sample.dto.ExceptionDto;
import com.scalar.sample.exception.CategoryNotFoundException;
import com.scalar.sample.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> doSomething(){
        ExceptionDto ed = new ExceptionDto();
        ed.setMessage("Something went wrong");
        ed.setResolution("Do nothing ");

        return new ResponseEntity<>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={CategoryNotFoundException.class})
    public ResponseEntity<ExceptionDto> handleCategoryNotFound(CategoryNotFoundException ce){
        //ErrorResponse er = new Error
        ExceptionDto ed = new ExceptionDto();
        ed.setMessage(" Exception : " + ce.getMessage());
        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
