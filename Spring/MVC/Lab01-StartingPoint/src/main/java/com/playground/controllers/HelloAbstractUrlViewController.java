package com.playground.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.AbstractUrlViewController;
import org.springframework.web.util.UrlPathHelper;

public class HelloAbstractUrlViewController extends AbstractUrlViewController {

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    protected String getViewNameForRequest(HttpServletRequest request) {
        String viewName= null;

        String requestPath = new UrlPathHelper().getPathWithinApplication(request);
        System.out.println("Hello Abstract Url View Controller : request path = " + requestPath);
        LOGGER.log(Level.INFO, "Hello Abstract Url View Controller : request path = " + requestPath);

        if(requestPath.equalsIgnoreCase("/hello2.htm")){
            viewName ="helloPage";
        }

        return viewName;
    }

}