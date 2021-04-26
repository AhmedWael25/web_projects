package com.example.EJBs.impl;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;

import java.util.logging.Logger;

@Singleton
public class DependentBean {

    private String init="";

    private static Logger logger = Logger.getLogger(
            DependentBean.class.getName());

    @PostConstruct
    private void init(){
        System.out.println("Dependent Bean has been initialized");

        logger.info("LOGG PELAAAASE");

        init = "Dependent Bean has been initialized";
    }

    public String getInitString(){
        return init;
    }

}
