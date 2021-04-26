package com.playground.test2.daos.userdao;


import javax.annotation.*;
import org.springframework.beans.factory.InitializingBean;

public class UserDaoImpl implements UserDaoInt, InitializingBean{


    UserDaoImpl(){
        System.out.println("UserDaoImpl : UserDaoImpl()"+ this.hashCode());
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("From postConstruct() method");
    }

    public void init(){
        System.out.println("From init() method");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("From afterPropertiesSet() method");
    }

    @PreDestroy
    public void destory(){
        System.out.println("From destory() annotation method");

    }



}