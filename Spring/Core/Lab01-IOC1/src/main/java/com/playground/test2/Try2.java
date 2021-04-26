package com.playground.test2;


import com.playground.test2.models.Child;
import com.playground.test2.models.ContextProvider;
import com.playground.test2.models.Parent;
import com.playground.test2.service2.AccountServiceImpl;
import com.playground.test2.service2.PropertiesReaderService;

import org.springframework.context.*;
import org.springframework.context.support.*;


public class Try2{

    public static void main(String[] args) {
        
        System.out.println("HELLO SERVICE 2");
        // ApplicationContext factory = new ClassPathXmlApplicationContext("beans2.xml");


        // ApplicationContext factory = new ClassPathXmlApplicationContext("beans4.xml");

        //Trial 1
        //This wil throw eception bec parent defin. is abstract
        // Parent parentBean1 = factory.getBean("parentDefinition1", Parent.class);
        // System.out.println(parentBean1);
        // Child childBean1 = factory.getBean("childDefinition1", Child.class);
        // System.out.println(childBean1);

        //Trial 2
        // Parent parentBean1 = factory.getBean("childDefinition1", Parent.class);
        // System.out.println(parentBean1);
        //Print======
        // Parent Bean: Parent()
        // Parent(name=NameOverriden, age=20)
        //==========

        //Trial3
        // Parent parentBean1 = factory.getBean("parentDefinition1", Parent.class);
        // System.out.println(parentBean1);
        // Child childBean1 = factory.getBean("childDefinition1", Child.class);
        // System.out.println(childBean1);
        /* Print==>
        Parent Bean: Parent()
        Child Bean: Child()
        Parent(name=myName, age=20)
        Child(name=myName, age=20, address=addressFromChild)
        */

        //Trial 4
        // Child childBean1 = factory.getBean("childDefinition1", Child.class);
        // System.out.println(childBean1);
        /* Parent ==>
            Child Bean: Child()
            Child(name=childOverriden, age=20, address=addressFromChild)
        */

        //Trial 5
        //  Child childBean1 = factory.getBean("childDefinition1", Child.class);
        // System.out.println(childBean1);
        // childBean1.printList();
        // childBean1.printSet();
        /* print ==>
        Child Bean: Child()
        Child(name=childOverriden, age=20, address=addressFromChild, myList=[value1, value2, value3, value4], mySet=[valueSet1, valueSet2, valueSet3])
        [value1, value2, value3, value4]
        [valueSet1, valueSet2, valueSet3]
        */

        System.out.println("==========================================");
        System.out.println("==========================================");

        // ApplicationContext context = new ClassPathXmlApplicationContext("beans5.xml");
        // //Trial 1 COntext Injection
        // ContextProvider contextProvider1 = context.getBean("contextProviderBean1", ContextProvider.class);
        // System.out.println(contextProvider1);
        // ContextProvider contextProvider2 = context.getBean("contextProviderBean2", ContextProvider.class);
        // System.out.println(contextProvider2);
        // ContextProvider contextProvider3 = context.getBean("contextProviderBean3", ContextProvider.class);
        // System.out.println(contextProvider3);
        /* last one testgreedy wont be null if we put it in constructor.
            Parent Bean: Parent()
            Context Provider : ContextProvider()
            Context Provider : ContextProvider()
            Context Provider : (ApplicationContext appcontext1, ApplicationContext appcontext2, Parent tst)
            ContextProvider(appcontext1=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, appcontext2=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, testForGreedy=null)
            ContextProvider(appcontext1=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, appcontext2=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, testForGreedy=Parent(name=null, age=0))
            ContextProvider(appcontext1=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, appcontext2=org.springframework.context.support.ClassPathXmlApplicationContext@383f5b11, started on Thu Apr 22 01:32:38 EET 2021, testForGreedy=null)
        */

        System.out.println("==========================================");
        System.out.println("==========================================");

        ApplicationContext context2 = new ClassPathXmlApplicationContext("beans6.xml");

        System.out.print(context2.getBean("propsReader2", PropertiesReaderService.class));
        

        // AccountServiceImpl accountService = context2.getBean("accountService1",AccountServiceImpl.class);
        // System.out.println(accountService);


        // PropertiesReaderService pService = context2.getBean("propsReader1",PropertiesReaderService.class);
        // System.out.println(pService);

    }
}