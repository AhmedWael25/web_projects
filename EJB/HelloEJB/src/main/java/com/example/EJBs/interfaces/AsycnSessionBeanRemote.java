package com.example.EJBs.interfaces;


import jakarta.ejb.Local;
import jakarta.ejb.Remote;

import java.util.concurrent.Future;

@Remote
public interface AsycnSessionBeanRemote {

    public void slowMethod();
    public Future<Long> slowMethodWithReturnValue();

}
