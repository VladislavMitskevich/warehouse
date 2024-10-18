package com.example.warehouse.exception;

/**
 * Custom exception for resources not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
