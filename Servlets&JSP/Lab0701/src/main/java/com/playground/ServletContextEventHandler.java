/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.File;
import jakarta.servlet.*;
import java.io.FileReader;
import java.nio.charset.Charset;
/**
 *
 * @author Ahmed Wael
 */
public class ServletContextEventHandler implements ServletContextListener{
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        
        
        Integer requestCount = 0;
        Integer sessionCount = 0;
        
        ServletContext cntxt = sce.getServletContext();
      
            
        
        
        try {
            Path path = Path.of("C:\\webdev\\web_projects\\Servlets&JSP\\mylog.txt");
            String str = Files.readString(path).trim();
            
            requestCount =  Integer.parseInt( str.split(";")[0]);
            sessionCount =  Integer.parseInt( str.split(";")[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
         
        cntxt.setAttribute("requestCount", requestCount);
        cntxt.setAttribute("sessionCount",sessionCount);
             

        System.out.println("INIT" +requestCount + ";" + sessionCount + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        
        Integer requestCount = 0;
        Integer sessionCount = 0;
        
        ServletContext cntxt = sce.getServletContext();
        requestCount = (Integer)cntxt.getAttribute("requestCount");
        sessionCount = (Integer)cntxt.getAttribute("sessionCount");
        
        try {
            
            Path path = Path.of("C:\\webdev\\web_projects\\Servlets&JSP\\mylog.txt");

              Files.writeString(path, requestCount + ";" + sessionCount, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        System.out.println("DES" +requestCount + ";" + sessionCount + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        
    } 

}