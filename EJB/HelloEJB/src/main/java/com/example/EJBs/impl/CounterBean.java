package com.example.EJBs.impl;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
@DependsOn("DependentBean")
public class CounterBean {

    private  int hitCount = 0;

    @PostConstruct
    private  void init(){
        hitCount = 1;
        System.out.println("Counter Bean has been initialized");
    }

    public int getHitCount(){
        return hitCount++;
    }


}
