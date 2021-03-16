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
public class CountRequestEventHandler implements ServletRequestListener{
    
    
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("REQdES");
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent sre){
        
        
        ServletContext servletContext = sre.getServletContext();
        Integer requestCount = (Integer)servletContext.getAttribute("requestCount");
        
        requestCount++;
        
        servletContext.setAttribute("requestCount", requestCount);
        System.out.println("REQinit" + requestCount);
        
    }
    
      
    
}
