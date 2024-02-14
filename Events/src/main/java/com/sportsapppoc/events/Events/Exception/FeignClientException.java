package com.sportsapppoc.events.Events.Exception;

public class FeignClientException extends RuntimeException{
    private String message;

    public FeignClientException(String message) {
        super(message);
        this.message = message;
    }
}
