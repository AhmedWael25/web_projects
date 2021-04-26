package com.example.EJBs.impl;

import com.example.EJBs.interfaces.AsycnSessionBeanRemote;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.AsyncResult;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;

import java.util.concurrent.Future;

@Stateless
public class AsycnSessionBean implements AsycnSessionBeanRemote {

    @PostConstruct
    public  void init(){
        System.err.println("HELLOOOO");
    }

    @Override
    @Asynchronous
    public void slowMethod() {
        long startTime = System.currentTimeMillis();
        System.out.println("Entering slow method");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            System.out.println("err");
        }
        long endTime = System.currentTimeMillis();

        System.out.println("slow method with no return");
        System.out.println("execution took " + (endTime - startTime) + " milliseconds");
    }

    @Override
    @Asynchronous
    public Future<Long> slowMethodWithReturnValue() {
        System.out.println("Entered Slow With Return");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        System.out.println("slow method with return");
        return new AsyncResult<Long>(420L);
    }
}
