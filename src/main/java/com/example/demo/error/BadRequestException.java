package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Resource not found exception class
 * @author Paulo Pigassi
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * Default constructor
     * @param message {@link java.lang.String} exception message
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * Clear stack trace from object
     * @return {@link java.lang.Throwable}
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
