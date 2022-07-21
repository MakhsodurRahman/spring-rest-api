package com.makhsodur.springdemo.exceptions;

import lombok.Data;

@Data
public class CustomersNotFoundException extends RuntimeException{

    public CustomersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomersNotFoundException(String message) {
        super(message);
    }

    public CustomersNotFoundException(Throwable cause) {
        super(cause);
    }
}
