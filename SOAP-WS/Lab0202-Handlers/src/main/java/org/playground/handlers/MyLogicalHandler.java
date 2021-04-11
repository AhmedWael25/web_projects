package org.playground.handlers;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.LogicalMessageContext;
import jakarta.xml.ws.handler.LogicalHandler;

public class MyLogicalHandler implements LogicalHandler<LogicalMessageContext>{


    @Override
    public boolean handleMessage(LogicalMessageContext ctx){
        System.out.println("FROM LOGICAL HANDLE MSG");
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext ctx){
        System.out.println("FROM LOGICAL HANDLE FAULT");
        return true;
    }

    @Override
    public void close(MessageContext ctx){
        System.out.println("FROM LOGICAL CLOSE");
    }

    

}