/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author Ahmed Wael
 */
public class CountSessionEventHandler implements HttpSessionListener{
    
    
    @Override
    public void sessionCreated(HttpSessionEvent se){
        
        ServletContext servletContext = se.getSession().getServletContext();
        Integer sessionCount = (Integer)servletContext.getAttribute("sessionCount");
        
        sessionCount++;
        servletContext.setAttribute("sessionCount", sessionCount);
        
        
        System.out.println("SESSnit"+ sessionCount);
    }
    
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        ServletContext servletContext = se.getSession().getServletContext();
        Integer sessionCount = (Integer)servletContext.getAttribute("sessionCount");
        
        sessionCount--;
        servletContext.setAttribute("sessionCount", sessionCount);
        System.out.println("SESSnit"+ sessionCount);
    }

    
}
