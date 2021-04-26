package com.playground.aop.advices;

public class CalcAdvice {
    
    public void before(double x, String op, double y){
        System.out.println(x + op + y);
    }

    public void after(double result){
        System.out.println("Reesult is : "+ result);
    }

    public void afterThrowing(Exception e){
        System.out.println(e.getMessage());
    }

}
