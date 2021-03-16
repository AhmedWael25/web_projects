package com.playground;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class ValidationServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;


	public void init(ServletConfig config) throws ServletException {
		this.config = config;

		ServletContext servletContext = config.getServletContext();
		conn = (Connection)servletContext.getAttribute("dbconn");
	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		String username = req.getParameter("username");
		if(username.equals("mak") || username.equals("asd")){
			out.print("Not Valid username");
		}else {
			out.print("Valid");
		}

	}
	


}
	