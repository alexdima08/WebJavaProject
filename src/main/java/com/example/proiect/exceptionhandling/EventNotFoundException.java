package com.example.proiect.exceptionhandling;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message) {
        super(message);
    }
}
