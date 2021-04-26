package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
public class CalcBefore2 {

    //Define Pointcut with aspect j expression
    @Before("execution(* com.playground.services.Calculator.add(..))")
    public void before(JoinPoint joinpoint){
        System.out.println("From @Before (2) => " + joinpoint);
    }
    
}
