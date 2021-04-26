package com.playground.aop.advices;

import org.springframework.aop.ThrowsAdvice;

public class CalcAfterThrow  implements ThrowsAdvice{

    public void afterThrowing(IllegalArgumentException e) throws Throwable{
        System.out.print("From Calc Throw =>");
        System.out.println("Illegal Args ....");
    }
    
}
