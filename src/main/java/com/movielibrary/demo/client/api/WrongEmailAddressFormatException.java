package com.movielibrary.demo.client.api;

public class WrongEmailAddressFormatException extends RuntimeException{

    public WrongEmailAddressFormatException(String message){
        super(message);
    }
}
