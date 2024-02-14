package com.sportsapppoc.events.Events.Exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String field;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String field, int fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,field,fieldValue));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldValue = fieldValue;
    }
}