package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class UserSignInRegServlet extends HttpServlet{
	
	ServletConfig config;



	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");
		out.println("<center style='margin-top:50px'> ");
		out.println("<a style='margin:50px' href='/userControls/signin'>SignIn</a>");
		out.println("<a style='margin:50px' href='/userControls/register'>Register</a>");
		out.println("</center>");

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{


	}
	
	


}
	