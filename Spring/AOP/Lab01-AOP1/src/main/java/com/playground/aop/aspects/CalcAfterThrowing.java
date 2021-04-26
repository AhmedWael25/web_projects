package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CalcAfterThrowing {

    //Define Pointcut with aspect j expression
    //We resitrected it to intercept on having an IllegalArgumentExc...
    @AfterThrowing(pointcut = "execution(* com.playground.services.Calculator.add(..))", throwing = "illegalarg")
    public void afterThrow(JoinPoint joinpoint, IllegalArgumentException illegalarg) throws Throwable{
        System.out.println("From @AfterThrowing => " + joinpoint);
        System.out.println("Exception ......... xxxxxx" + illegalarg .getMessage());
    }
    
}
