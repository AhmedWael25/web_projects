package com.playground.handlermappings;

import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

public class MyAbstractDetectingUrlHandlerMapping extends AbstractDetectingUrlHandlerMapping{

    @Override
    protected String[] determineUrlsForHandler(String controllerId) {
        String mappings[] = null;

        System.out.println("In Abstract Detecting URL Handler, Controller ID = "+ controllerId);
        if(controllerId.equalsIgnoreCase("helloController")){
            System.out.println("ControllerId Matched that of helloController");
            mappings = new String[2];
            // We Can add multiple URL Patterns
            mappings[0]= "/abstract2.htm";
            mappings[1]= "/abstract2-5.htm";
        }else{
            System.out.println("ControllerId  DIDNOT MATCH ");
        }
        return mappings;
    }

}