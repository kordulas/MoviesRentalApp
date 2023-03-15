package com.movielibrary.demo.client.api;

public class ClientAlreadyExistException extends RuntimeException {

    public ClientAlreadyExistException(String message) {
        super(message);
    }
}