package com.example.EJBs.interfaces;


import jakarta.ejb.Local;

@Local
public  interface HelloBean {
        String sayHello();
}

