package com.playground.aop.aspects;

import com.playground.services.MaxCalc;
import com.playground.services.MaxCalcImpl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;


@Aspect
public class CalculatorAspect {
    
    @Pointcut("execution(* com.playground.services..add(..))")
    private void pointCutProvider(){}


    //Define default impl proxy will have + class that doesnot impl it
    @DeclareParents(defaultImpl = com.playground.services.MaxCalcImpl.class, value="com.playground.services.CalculatorServiceImpl")
    public MaxCalc maxCalc;


    //Ordering doesnot have any effect when order is on methods
    // @Before("pointCutProvider()")
    // @Order(0)
    // public void before2(JoinPoint joinpoint){
    //     System.out.println("From @Before (order:0) => " + joinpoint);
    // }
   
    @Before("pointCutProvider()")
    // @Order(0)
    public void before1(JoinPoint joinpoint){
        System.out.println("From @Before (order:10)=> " + joinpoint);
    }


    @Around("pointCutProvider()")
    // @Order(10)
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


    @AfterThrowing(pointcut = "pointCutProvider()", throwing = "illegalarg")
    public void afterThrow(JoinPoint joinpoint, IllegalArgumentException illegalarg) throws Throwable{
        System.out.println("From @AfterThrowing => " + joinpoint);
        System.out.println("Exception ......... xxxxxx" + illegalarg .getMessage());
    }


    //Define Pointcut with aspect j expression
    //To Access return object in  method
    @AfterReturning(returning = "result",pointcut = "pointCutProvider()")
    public void afterReturn(JoinPoint joinpoint, Object result){
        System.out.println("From @AfterReturning => " + joinpoint);
        System.out.println("@AfterReturning : Result => " + result);
    }


    @After("pointCutProvider()")
    public void after(JoinPoint joinpoint){
        System.out.println("From @After => " + joinpoint);
    }




}
