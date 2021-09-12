package com.devlogs.masa_backend.domain.errors;

public class NotFoundException extends Exception {
    public NotFoundException (String message){
        super(message);
    }
}
