package com.movielibrary.demo.client.api;

public class WrongPeselFormatException extends RuntimeException {
    public WrongPeselFormatException(String message) {
        super(message);
    }
}
