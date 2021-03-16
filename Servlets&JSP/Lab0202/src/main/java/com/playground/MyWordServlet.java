package com.playground;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class MyWordServlet implements Servlet{
	
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside init");
		this.config = config;
	
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		
		response.setContentType("application/msword");
		PrintWriter out = response.getWriter();
		out.println("FROM MY AWESOME WORD SERVLET \\O/");
	
	}
	
	public void destroy(){
		
		System.out.println("detroy");

	}
	
	
	public String  getServletInfo(){
		
		return null;
	}
	
	
	
	public ServletConfig getServletConfig(){
		
		return null;
	}
	
}
	