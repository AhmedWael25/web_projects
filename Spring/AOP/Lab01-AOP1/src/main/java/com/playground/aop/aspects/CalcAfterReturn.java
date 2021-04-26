package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CalcAfterReturn {

    //Define Pointcut with aspect j expression
    //To Access return object in  method
    @AfterReturning(returning = "result",pointcut = "execution(* com.playground.services.Calculator.add(..))")
    public void afterReturn(JoinPoint joinpoint, Object result){
        System.out.println("From @AfterReturning => " + joinpoint);
        System.out.println("@AfterReturning : Result => " + result);
    }
    
}
