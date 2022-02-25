package com.posts.posts.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException (String message,Throwable cause) {
        super(message, cause);
    }

}
