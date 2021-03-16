package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class MySuccessServlet extends HttpServlet{
	
	ServletConfig config;



	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

		String name = req.getParameter("userName");

		out.println("<BR>Hello There:" + name);
		
	}


}
	