package com.playground;

import jakarta.servlet.*;
import java.io.*;

public class MyExcelServlet implements Servlet{
	
	ServletConfig config;
	
	public void init(ServletConfig config) throws ServletException{
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Inside init");
		this.config = config;
	
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		
		response.setContentType("application/vnd.ms-sheet");
		PrintWriter out = response.getWriter();
		out.println("\t jan \t feb \t march \t total");
		out.println("salary \t500 \t500 \t500 \t=sum(B2:D2)");
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
	