package com.playground.test1;

import com.playground.test1.service1.*;

public class ServiceFactory{

    private static Service1Interface service1Interface = new Service1Impl();

    public Service1Interface createService1Instance(){
        return service1Interface;
    }





}