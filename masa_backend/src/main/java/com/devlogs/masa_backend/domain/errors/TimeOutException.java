package com.devlogs.masa_backend.domain.errors;

public class TimeOutException extends Exception {
    public TimeOutException(String message) {
        super(message);
    }
}
