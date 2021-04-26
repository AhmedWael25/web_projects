package com.playground.aop.advices;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CalcAround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("From Calc Around =>");
        System.out.println("The Method : "+ invocation.getMethod().getName() + " : "+ Arrays.toString(invocation.getArguments()));

        Object result = null;

        try{
            System.out.println("===Before Proceeding");
            result = invocation.proceed();
            System.out.println("===After Proceeding");
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        System.out.println("From Calc Around => Before Returning");
        return result;
    }
    
}
