package com.example.EJBs.impl;


import com.example.EJBs.interfaces.HelloBean;
import jakarta.ejb.Stateless;

@Stateless
public class HelloBeanImpl implements HelloBean {


    @Override
    public String sayHello() {
        System.out.println("BLA BLA");
        return "Hello THERE FROM THE BEAN";
    }

}
