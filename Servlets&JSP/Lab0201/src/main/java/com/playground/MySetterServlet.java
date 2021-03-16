package com.playground;

import jakarta.servlet.*;
import java.io.*;

public class MySetterServlet implements Servlet{
	
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside init");
		this.config = config;
	
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		
		ServletContext sContext = config.getServletContext();
		sContext.setAttribute("myKey","FROM THE SETTER");

		PrintWriter out = response.getWriter();

		out.println("<br>I Have Set Your Stuff !!");

		
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
	