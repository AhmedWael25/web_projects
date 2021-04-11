package org.playground.resources.exceptions;


public class EmpNotFoundException extends RuntimeException {

    public EmpNotFoundException(String errMsg){
        super(errMsg);
    }
}