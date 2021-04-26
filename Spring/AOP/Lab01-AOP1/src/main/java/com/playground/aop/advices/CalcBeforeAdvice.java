package com.playground.aop.advices;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.aop.Advice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class CalcBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] arg1, Object target) throws Throwable {
        System.out.print("From Calc Before =>");
        System.out.println("The Method: "+ method.getName() + " : args :  "+ Arrays.toString(arg1));
    }


    //implements AfterReturningAdvice
    // @Override
    // public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    //     System.out.print("From Calc After Return =>");
    //     System.out.println("The method: "+ method.getName() + " : args : "+ Arrays.toString(args)+ " --- return > "+ returnValue);
        
    // }
    
}
