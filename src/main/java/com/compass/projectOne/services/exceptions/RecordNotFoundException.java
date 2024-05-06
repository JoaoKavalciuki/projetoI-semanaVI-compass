package com.compass.projectOne.services.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(Object id) {
        super("Resource of id " + id + " not found");
    }
}
