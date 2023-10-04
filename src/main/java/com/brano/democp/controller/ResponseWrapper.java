package com.brano.democp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public class ResponseWrapper {

    public static ResponseEntity<?> wrap(Responsible<?> responsible, HttpStatus status) {
        try {
            Object res = responsible.respond();
            return new ResponseEntity<>(res, status);
        } catch (Exception e) {
            System.err.println("BAD REQUEST: " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
