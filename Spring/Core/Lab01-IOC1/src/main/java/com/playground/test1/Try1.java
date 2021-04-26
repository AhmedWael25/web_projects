package com.playground.test1;


import java.io.IOException;

import com.playground.test1.service1.Service1Interface;
import com.playground.test2.service2.Service3Impl;

import org.springframework.context.*;
import org.springframework.context.support.*;

public class Try1{


    public static void main(String[] args) throws IOException{

        System.out.println("Helasdasdo THERE");
        // ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        // Service1Interface service1 = (Service1Interface) factory.getBean("simpleBean1");
        // Service1Interface service2 = (Service1Interface) factory.getBean("simpleBean3Name1");
        
        ConfigurableApplicationContext factory = new ClassPathXmlApplicationContext("beans2.xml");

        // ConfigurableApplicationContext factory = new ClassPathXmlApplicationContext("beans3.xml");
        // Service3Impl service3 = factory.getBean("simpleService3",Service3Impl.class);
        // Service3Impl service4 = factory.getBean("simpleService4",Service3Impl.class);
        // System.out.println(service3.getUserDaosList().size());
        // System.out.println(service3.getProdDaosMap());
        // System.out.println(service3.getProdDao1());


        // System.out.println(service4.getUserDaosList());
        // System.out.println(service4.getProdDaosMap());
        // System.out.println(service4.getProdDao1());

        // System.out.println(service4.getUserDaosList().size());
        // System.out.println(service4.getProdDaosMap());



        System.in.read();

        factory.close();
    
    }

}