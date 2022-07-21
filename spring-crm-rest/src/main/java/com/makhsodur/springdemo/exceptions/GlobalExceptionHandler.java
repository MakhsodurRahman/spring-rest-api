package com.makhsodur.springdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomersErrorResponse> handleException(CustomersNotFoundException ex){
        CustomersErrorResponse error = new CustomersErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<CustomersErrorResponse> handleException(Exception ex){
        CustomersErrorResponse error = new CustomersErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("type mismatch  ");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
