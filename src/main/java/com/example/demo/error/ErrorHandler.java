package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Error handler configuration
 * @author Paulo Pigassi
 */
@RestControllerAdvice
public class ErrorHandler {

    /**
     * Handle {@link BadRequestException} object
     * @param badRequestException managed exception
     * @return {@link BadRequestException}
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleResourceNotFoundException(BadRequestException badRequestException) {
        BadRequestDetails details = BadRequestDetails.BadRequestDetailsBuilder
                .newBuilder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request")
                .detail(badRequestException.getMessage())
                .developerMessage(badRequestException.getClass().getName())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String detail = "";
        for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            detail = detail.concat(error.getDefaultMessage()+"; ");
        }

        BadRequestDetails details = BadRequestDetails.BadRequestDetailsBuilder
                .newBuilder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request")
                .detail(detail)
                .developerMessage(methodArgumentNotValidException.getClass().getName())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

}
