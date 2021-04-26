package com.example.backingbeans;


import com.example.EJBs.impl.*;
import com.example.EJBs.interfaces.AsycnSessionBeanRemote;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Named("hits")
@ViewScoped
public class Hits implements Serializable {
    @EJB
    private AsycnSessionBeanRemote asycnSessionBean;
    @EJB
    private  CounterBean counterBean;
    @EJB
    private DependentBean dependentBean;
    @EJB
    private  AutoTimer autoTimer;
    @EJB
    private ProgTimer progTimer;



    private int hitCount ;
    private String dependentCheck= "";
    private Integer autoTimerCounter;
    private  Integer progTimerCounter;
    private Long asyncReturn = 0L;

    @PostConstruct
    public  void count()  {
        hitCount = counterBean.getHitCount();
        dependentCheck = dependentBean.getInitString();
        autoTimerCounter = autoTimer.getTimer();
        progTimerCounter = progTimer.getTimerCounter();
        //Asynch
        asycnSessionBean.slowMethod();
    }

    public Long getAsyncReturn() {
        return asyncReturn;
    }

    public void setAsyncReturn(Long asyncReturn) {
        this.asyncReturn = asyncReturn;
    }

    public Integer getProgTimerCounter() {
        return progTimerCounter;
    }

    public void setProgTimerCounter(Integer progTimerCounter) {
        this.progTimerCounter = progTimerCounter;
    }

    public int getAutoTimerCounter() {
        return autoTimerCounter;
    }

    public void setAutoTimerCounter(int autoTimerCounter) {
        this.autoTimerCounter = autoTimerCounter;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public String getDependentCheck() {
        return dependentCheck;
    }

    public void setDependentCheck(String dependentCheck) {
        this.dependentCheck = dependentCheck;
    }
}
