package com.devlogs.masa_backend.domain.errors;

public class HostDoesNotExistException extends Exception {
    public HostDoesNotExistException(String message) {
        super(message);
    }
}
