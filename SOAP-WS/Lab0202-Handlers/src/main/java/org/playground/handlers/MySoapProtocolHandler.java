package org.playground.handlers;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.*;


public class MySoapProtocolHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set getHeaders(){
        System.out.println("FROM GET HEADERS>>");
        return new HashSet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext ctx){
        System.out.println("FROM SOAP HANDLE MSG");
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext ctx){
        System.out.println("FROM SOAP HANDLE FAULT");
        return true;
    }

    @Override
    public void close(MessageContext ctx){
        System.out.println("FROM SOAP CLOSE");
    }


}