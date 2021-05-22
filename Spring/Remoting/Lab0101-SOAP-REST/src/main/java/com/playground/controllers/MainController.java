package com.playground.controllers;

import com.playground.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    HelloService helloService;

    @Autowired
    public MainController(HelloService helloService){
        this.helloService = helloService;
        System.out.println("==============CONTROLLLLER INIT=====================");
    }

    @GetMapping("/")
    public String printHello(){
        return helloService.sayHello();
    }

}
