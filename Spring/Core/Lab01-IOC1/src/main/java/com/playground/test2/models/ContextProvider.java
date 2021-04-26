package com.playground.test2.models;


import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;

import lombok.*;

@Setter @Getter @ToString
public class ContextProvider{

    @Resource
    private ApplicationContext appcontext1;
    @Autowired
    private ApplicationContext appcontext2;
    
    private Parent testForGreedy;

    public ContextProvider(ApplicationContext appcontext1, ApplicationContext appcontext2){
        System.out.println("Context Provider : (ApplicationContext appcontext1, ApplicationContext appcontext2)");
    }
    public ContextProvider(ApplicationContext appcontext1, ApplicationContext appcontext2, Parent tst){
        System.out.println("Context Provider : (ApplicationContext appcontext1, ApplicationContext appcontext2, Parent tst)");
        //Despite the contaienr calling this constructor , it didnot set the parent unlesss we pt it
        //it explicitly, but it deid put both app contexts
        // this.testForGreedy = tst;
        // this.appcontext1 = appcontext1;
        // this.appcontext2 = appcontext2;
    }
    public ContextProvider(ApplicationContext appcontext1){
        System.out.println("Context Provider : (ApplicationContext appcontext1)");
    }
    public ContextProvider(){
        System.out.println("Context Provider : ContextProvider()");
    }

    public void printContexts(){
        System.out.println("From @Resource : "+appcontext1);
        System.out.println("From @Autowired: "+appcontext2);
    }

    
}