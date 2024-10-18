package com.example.warehouse.exception;

/**
 * Custom exception to handle bad request scenarios.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
