package com.playground;

import com.playground.aop.advices.CalcAdvice;
import com.playground.aop.proxies.AbstractProxy;
import com.playground.aop.proxies.CalcProxy;
import com.playground.services.Calculator;
import com.playground.services.CalculatorServiceImpl;
import com.playground.services.MaxCalc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    
    
    public static void main(String[] args) {

        Calculator calculatorImpl = new CalculatorServiceImpl();

        Calculator calc1 = (Calculator) AbstractProxy.newInstance(calculatorImpl);

        double result1 =  calc1.add(5, 10);


        System.out.println("==========");

        Calculator calc2 = CalcFactory.getInstance();

        double  result2 = calc2.add(10, 1);

        System.out.println("===================================");
        System.out.println("=================Spring Based==================");


        ConfigurableApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");
        

        Calculator calc3 = ctxt.getBean("calcProxy1", Calculator.class);
        calc3.add(10, 10);

        System.out.println("-----");

        Calculator calc4 = ctxt.getBean("calcProxy2", Calculator.class);
        calc4.add(10, 20);
        calc4.mul(5, 10);
        calc4.sub(5, 10);
        // calc4.div(5, 0);

        System.out.println("-----");

        Calculator calc5 = ctxt.getBean("calc", Calculator.class);
        calc5.add(10, 20);
        calc5.mul(5, 10);
        
        System.out.println("===================================");
        System.out.println("==================ANNO BASED=================");

        ConfigurableApplicationContext ctxt2 = new ClassPathXmlApplicationContext("beans2.xml");
        Calculator calc = ctxt2.getBean("calc", Calculator.class);
        calc.add(10, 10);


        System.out.println();
        System.out.println("-----Max Interface, calling on Calc Int-----");
        System.out.println();

        MaxCalc maxCalc = (MaxCalc) calc;
        maxCalc.findMax(10, 20);
        ((Calculator)maxCalc).add(5,10);


        System.out.println("===================================");
        System.out.println("==================XML BASED=================");


        ConfigurableApplicationContext ctxt3 = new ClassPathXmlApplicationContext("beans3.xml");
        Calculator calc6 = ctxt3.getBean("calculatorImpl", Calculator.class);

        calc6.add(20, 20);
        

        ctxt.close();
        ctxt2.close();
        ctxt3.close();
    }

}