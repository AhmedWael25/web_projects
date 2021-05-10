package com.playground.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public ModelAndView welcomePage(){
        ModelAndView model = new ModelAndView();
        model.addObject("message", "This is the Welcome Page");
        model.addObject("title", "Welcome");
        model.setViewName("hello");
        return model;
    }


    @GetMapping(value ="/admin**")
    public ModelAndView adminPage(){
        ModelAndView model = new ModelAndView();
        model.addObject("message", "This is the Admin Page");
        model.addObject("title", "ADMIN");
        model.setViewName("hello");
        return model;
    }

}
