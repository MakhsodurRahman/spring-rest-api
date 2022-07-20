package com.makhsodur.springdemo.rest;

import lombok.Data;

@Data
public class Student {

    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
