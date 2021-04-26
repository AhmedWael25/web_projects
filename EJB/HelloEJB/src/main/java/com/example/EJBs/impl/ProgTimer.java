package com.example.EJBs.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Singleton
@Startup
public class ProgTimer {


    @Resource
    private TimerService timerService;

    private  Integer progTimerCounter;

    @Timeout
    public  void timeOut(){
        progTimerCounter++;
        System.out.println("Programmatic Timer Method Invoked! ");
    }

    @PostConstruct
    public  void initProgTimer(){
        progTimerCounter = 0;
        System.out.println("Prog Timer Init");
        ScheduleExpression exp = new ScheduleExpression();
        exp.hour("*").minute("*").second("*/1");
        timerService.createCalendarTimer(exp) ;
    }

    public Integer getTimerCounter(){
        return  progTimerCounter;
    }

}
