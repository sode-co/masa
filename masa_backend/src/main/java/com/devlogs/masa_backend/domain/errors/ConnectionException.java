package com.devlogs.masa_backend.domain.errors;

public class ConnectionException extends Exception {
    public ConnectionException(String message){
        super(message);
    }
}
