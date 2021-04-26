package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
public class CalcBefore {

    //Define Pointcut with aspect j expression
    @Before("execution(* com.playground.services..add(..))")
    public void before(JoinPoint joinpoint){
        System.out.println("From @Before => " + joinpoint);
    }
    
}
