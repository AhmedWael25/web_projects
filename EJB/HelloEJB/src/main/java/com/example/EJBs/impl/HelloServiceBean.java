package com.example.EJBs.impl;


import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Stateless
@WebService(serviceName = "hello" ,name = "hello")
public class HelloServiceBean {

    HelloServiceBean(){}


    @WebMethod(operationName = "sayHi")
    public String sayHi(){
        return "Hi!, ";
    }


}
