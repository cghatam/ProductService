package com.scalar.sample.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class APIError {
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private APIError(){ }

    public APIError(HttpStatus status){
        this();
        this.status = status;
    }

    public APIError(HttpStatus status, Throwable th){
        this();
        this.status = status;
        this.message = "Unexpected Error";
        this.debugMessage = th.getLocalizedMessage();
    }

    public APIError(HttpStatus status, String message, Throwable th){
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = th.getLocalizedMessage();
    }



}
