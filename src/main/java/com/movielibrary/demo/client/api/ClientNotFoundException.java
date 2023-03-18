package com.movielibrary.demo.client.api;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(Long id) {
        this("Client with " + id +" was not found");
    }
}
