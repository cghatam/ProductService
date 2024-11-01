package com.scalar.sample.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor

public class ApiSubError {
    private String object;
    private String field;
    private Object rejectedValues;
    private String message;

    public ApiSubError(String object, String message){
        this.object = object;
        this.message = message;
    }


}
