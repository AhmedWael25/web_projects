package com.playground.controllers;



import org.springframework.web.servlet.mvc.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.*;

public class FormController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        
        //The Logical View Name
        ModelAndView model =  new ModelAndView("myForm");
        return model;
    }
}