package com.rosatel.api.Exceptions;

public class EmailAlreadyExitsException extends RuntimeException {
    public EmailAlreadyExitsException(String message){
        super(message);
    }
}
