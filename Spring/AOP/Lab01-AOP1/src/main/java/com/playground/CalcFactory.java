package com.playground;

import java.lang.reflect.Proxy;

import com.playground.aop.advices.CalcAdvice;
import com.playground.aop.proxies.CalcProxy;
import com.playground.services.Calculator;
import com.playground.services.CalculatorServiceImpl;

public class CalcFactory {

    private static CalcFactory calcFactory = new CalcFactory();

    private final Calculator targetCalc;
    private final Calculator targetWithAviceCalc;

    private CalcFactory(){
        targetCalc = new CalculatorServiceImpl();
        CalcAdvice advice = new CalcAdvice();
        CalcProxy calcProxy = new CalcProxy(targetCalc,advice);
        
        //Next we define Proxy instances;
        Class[] interfaces = new Class[]{Calculator.class};

        targetWithAviceCalc = (Calculator) Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, calcProxy);
    }

    public static Calculator getInstance(){
        return calcFactory.targetWithAviceCalc;
    }

    public Calculator getCalculator(){
        return targetWithAviceCalc;
    }


}
