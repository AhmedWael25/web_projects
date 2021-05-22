package com.playground.controllers.exceptions;

public class CustomException extends RuntimeException{

    public CustomException(String err){
        super(err);
    }
}
