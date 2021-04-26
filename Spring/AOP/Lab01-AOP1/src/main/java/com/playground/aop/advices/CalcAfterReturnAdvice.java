package com.playground.aop.advices;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class  CalcAfterReturnAdvice implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] arg2, Object target) throws Throwable {
        System.out.print("From Calc After Return =>");
        System.out.println("The method: "+ method.getName() + " : args : "+ Arrays.toString(arg2)+ " --- return > "+ returnValue);
        
    }


}