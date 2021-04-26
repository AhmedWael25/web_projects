package com.playground.aop.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.playground.aop.advices.CalcAdvice;
import com.playground.services.Calculator;

public class CalcProxy implements InvocationHandler{

    public Calculator calculator;
    public CalcAdvice calcAdvice;

    public CalcProxy(Calculator calculator, CalcAdvice calcAdvice){
        this.calculator = calculator;
        this.calcAdvice = calcAdvice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        double result = 0;
        double x = (double)args[0];
        double y = (double)args[1];
        

        switch(method.getName()){
            case "add":
                try{
                    calcAdvice.before(x, "+", y);
                    // result = (double)method.invoke(calculator, args);
                    result = calculator.add(x, y);
                    calcAdvice.after(result);
                }catch(Exception e){
                    calcAdvice.afterThrowing(e);
                }
                break;
            case "sub":
                try{
                    calcAdvice.before(x, "-", y);
                    // result = (double)method.invoke(calculator, args);
                    result = calculator.sub(x, y);
                    calcAdvice.after(result);
                }catch(Exception e){
                    calcAdvice.afterThrowing(e);
                }
                break;
            case "mul":
                try{
                    calcAdvice.before(x, "*", y);
                    // result = (double)method.invoke(calculator, args);
                    result = calculator.mul(x, y);
                    calcAdvice.after(result);
                }catch(Exception e){
                    calcAdvice.afterThrowing(e);
                }
                break;
            case "div":
                try{
                    calcAdvice.before(x, "/", y);
                    // result = (double)method.invoke(calculator, args);
                    result = calculator.div(x, y);
                    calcAdvice.after(result);
                }catch(Exception e){
                    calcAdvice.afterThrowing(e);
                }
                break;
        }

        return result;
    }

}