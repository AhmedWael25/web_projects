package com.playground;

import jakarta.servlet.*;
import java.io.*;

public class MyServlet implements Servlet{
	
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside init");
		this.config = config;
	
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		
		response.setContentType("text/html");
		System.out.println("==============================Service");
		String str = config.getInitParameter("DBusername");
		PrintWriter out = response.getWriter();
		out.println("<br>====-=-=-=-=-=-=--=-=-=");
		out.println("<br>====-=-=-=-=-=-=--=-=-=");
		out.println("<br>====-=-=-=-=FROM CONFIG PARAMS-=-=--=-=-=");
		out.println("<br>"+str);
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
	