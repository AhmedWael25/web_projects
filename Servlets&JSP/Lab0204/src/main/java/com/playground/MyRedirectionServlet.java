package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class MyRedirectionServlet extends HttpServlet{
	
	ServletConfig config;



	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

		String str = req.getParameter("Err");
		if(str != null){
			out.println("<BR> ERROR, Check Yoour Credentials");
		}
		out.println("<FORM method= POST>");
		out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR> Password: <INPUT TYPE=PASSWORD	NAME=password>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{


		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		
		if(checkCredentials(userName,password)){
			resp.sendRedirect("success?userName="+userName);

		}else{

			resp.sendRedirect("red?Err=");
		}
	}
	
	

	private boolean checkCredentials(String userName, String pw){
		
		final String user = "ahmed";
		final String upw = "123";
		

		if(userName == null || userName.equals("") || !userName.equals(user)) return false;
		if(pw == null || pw.equals("") || !pw.equals(upw)) return false;

		return true;
	}

}
	