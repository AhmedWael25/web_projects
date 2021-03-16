package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class MyHttpServlet extends HttpServlet{
	
	ServletConfig config;



	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();
		out.println("HELLO");

		Enumeration<String> hdrNames = req.getHeaderNames();

	while(hdrNames.hasMoreElements()){

		String name = hdrNames.nextElement();

		Enumeration<String> hdrs = req.getHeaders(name);

		while (hdrs.hasMoreElements()){
			String val = hdrs.nextElement();
			out.println( name  +" : " + val);
		

		}
	}

		
	}
	

}
	