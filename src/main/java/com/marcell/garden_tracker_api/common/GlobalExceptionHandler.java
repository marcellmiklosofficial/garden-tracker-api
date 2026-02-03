package com.marcell.garden_tracker_api.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> handleNotFound(NotFoundException exception) {
        return Map.of(
                "timestamp", Instant.now().toString(),
                "error", "NOT_FOUND",
                "message", exception.getMessage()
        );
    }
}
