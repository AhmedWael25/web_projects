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
		HttpSession session = req.getSession();
		String myUserName = (String) session.getAttribute("myUserName");

		out.println("<center>");
		out.println("<h2 style='margin:30px auto;'>Hello There : "+myUserName+"</h2>");

		out.println("<h5><a href='/cookieexamples/logout'>LOG ME OUT !</a></h5>");

		out.println("</center>");

	}


}
	