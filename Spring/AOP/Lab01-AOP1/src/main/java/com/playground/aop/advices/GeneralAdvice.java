package com.playground.aop.advices;

public class GeneralAdvice {
    
    public void before(Object[] args){
        for(Object argument:args){
            System.out.println(argument);
        }
    }

    public void after(Object  result){
        System.out.println("Result is: "+result);
    }
    public void afterThrows(Exception e){
        System.out.println(e.getMessage());
    }
}
