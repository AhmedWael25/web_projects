package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class SignInServlet extends HttpServlet{
	
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

	}
	


}
	