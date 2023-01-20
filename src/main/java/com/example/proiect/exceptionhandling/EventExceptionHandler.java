package com.example.proiect.exceptionhandling;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class EventExceptionHandler {

    @ExceptionHandler({EventNotFoundException.class})
    public ResponseEntity<?> handleEventNotFound(EventNotFoundException e){
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<String>> handleValidaton(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest()
                .body(e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
    }
}
