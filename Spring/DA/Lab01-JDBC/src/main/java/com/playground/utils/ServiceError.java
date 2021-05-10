package com.playground.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ServiceError {

    private  int code;
    private String  message;

    public ServiceError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
