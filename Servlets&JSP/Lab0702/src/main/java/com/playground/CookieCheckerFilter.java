/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playground;



import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
/**
 *
 * @author Ahmed Wael
 */
public class CookieCheckerFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Cookie FILTER INIT");
        
        
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Cookie FILTER INIT ..DIVING IN");
        
        
        
        

        chain.doFilter(request, response);
        
        System.out.println("Coooke FILTER INIT ..DIVING OUT");
    }
    
}
