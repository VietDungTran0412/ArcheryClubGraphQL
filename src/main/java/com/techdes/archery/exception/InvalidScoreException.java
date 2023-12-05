package com.techdes.archery.exception;

public class InvalidScoreException extends RuntimeException{
    private static final long serialVersionUID = 2709017199190266433L;
    public InvalidScoreException(String message) {super(message);}
}
