package org.cherif.mediatheque.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
    }


    public EntityNotFoundException(String message) {
        super(message);
    }
}
