package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CalcAfter {

    //Define Pointcut with aspect j expression
    @After("execution(* com.playground.services.Calculator.add(..))")
    public void after(JoinPoint joinpoint){
        System.out.println("From @After => " + joinpoint);
    }
    
}
