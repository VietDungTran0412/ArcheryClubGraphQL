package com.techdes.archery.exception;

public class NotExistedException extends RuntimeException{
    private static final long serialVersionUID = 2709017199190266433L;
    public NotExistedException(String message) {super(message);}
}
