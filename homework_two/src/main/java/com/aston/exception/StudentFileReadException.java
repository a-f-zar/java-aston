package com.aston.exception;

public class StudentFileReadException extends RuntimeException {

    public StudentFileReadException(String message) {
        super(message);
    }

    public StudentFileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}