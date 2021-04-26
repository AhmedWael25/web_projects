package com.playground.test2.service2;


import com.playground.test2.models.Child;
import com.playground.test2.models.Parent;

import lombok.*;
import org.springframework.context.support.*;
import org.springframework.beans.factory.annotation.*;
import javax.annotation.*;


@Setter @Getter @ToString
public class PropertiesReaderService{

    private String url;
    private String password;
    private String admin;

    @Resource
    private Child child;

    // @Autowired
    // @Qualifier("parent1")
    // private Parent parent;

    private PropertiesReaderService(){
        System.out.println("Props Service: PropertiesReaderService()");
    }







}