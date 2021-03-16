package com.playground;

import jakarta.servlet.*;
import java.io.*;

public class MyGetterServlet implements Servlet{
	
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside init");
		this.config = config;
	
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletContext sContext = config.getServletContext();

		String country = sContext.getInitParameter("Country");
		String city = sContext.getInitParameter("City");


		System.out.println(sContext.getInitParameterNames());


		out.println("<br>Country is:"+ country);

		out.println("<br>City is:"+ city);


		String attr = (String)sContext.getAttribute("myKey");
		out.println("<br>Attribute Is:"+ attr);
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
	