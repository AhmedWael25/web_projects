/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;



import java.io.*;
import jakarta.servlet.*;
import java.nio.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.File;
import jakarta.servlet.*;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
/**
 *
 * @author Ahmed Wael
 */
public class IPFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
        System.out.println("IP FILTER INIT");
        
        
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DOING FILTER INIT ..DIVING IN");
        
        
        String ipAdd = request.getRemoteAddr();
        
        
        try{
            Path p = Path.of("C:\\webdev\\web_projects\\Servlets&JSP\\myIPlog.txt");
            Files.writeString(p, (ipAdd+System.lineSeparator()+"\n"), Charset.defaultCharset(), StandardOpenOption.APPEND);
        }catch(IOException  e){
            e.printStackTrace();
        }

        chain.doFilter(request, response);
        
        System.out.println("DID FILTER INIT ..DIVING OUT");
    }
    
}
