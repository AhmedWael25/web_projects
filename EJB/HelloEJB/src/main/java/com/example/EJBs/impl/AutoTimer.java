package com.example.EJBs.impl;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;

import java.util.logging.Logger;

@Singleton
public class AutoTimer {

    private  Integer timerCounter;


    @PostConstruct
    private  void init(){
        timerCounter = 0;
    }

    @Schedule(hour="*", minute="*", second="*/2")
    public  void timeOut(){
        timerCounter++;
        System.out.println("Method Invoked!");
    }

    public  Integer getTimer(){
        return  timerCounter;
    }
}
