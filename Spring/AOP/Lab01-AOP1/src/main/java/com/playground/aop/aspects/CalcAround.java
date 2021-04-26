package com.playground.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
public class CalcAround {

    //Define Pointcut with aspect j expression
    @Around("execution(* com.playground.services.Calculator.add(..))")
    public Object around(ProceedingJoinPoint joinpoint) throws Throwable{
        
        System.out.println("From @Around => " + joinpoint);

        Object result = null;

        try{
            System.out.println("===Before proceeding");
            result = joinpoint.proceed();
            System.out.println("===after proceeding");
        }catch(IllegalArgumentException ex){
            // ex.printStackTrace();
            throw ex;
        }
        System.out.println("From @Around => : RETURNING");
        return result;
    }
    
}
