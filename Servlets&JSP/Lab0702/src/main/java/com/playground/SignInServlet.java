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

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");


		out.println("<center>");
		out.println("<h1 style='margin:50px auto;'>Signin Form</h1>");
		out.println("<h4 style='margin:20px auto;'>Enter Your Details</h4>");

		String str = req.getParameter("Err");
		if(str != null){
			out.println("<BR> ERROR, Check Your Credentials");
		}


		out.println("<FORM action='signin'  method= POST>");


		out.println("<div style='margin:50px auto;>");
		out.println("<label for='userName' style='font-size:20px;margin-right:10px;'>UserName : </label>");
		out.println("<INPUT TYPE=TEXT NAME=userName><BR>");
		out.println("</div>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='pw' style='font-size:20px;margin-right:10px;'>Password : </label>");
		out.println("<INPUT TYPE=TEXT NAME=pw><BR>");
		out.println("</div>");


		out.println("<BR> <INPUT style='background-color:cyan;color:white;font-size20px;' TYPE=SUBMIT VALUE=Submit><BR>");

		out.println("</FORM>");


		out.println("</center>");

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{


		String userName = req.getParameter("userName");
		String password = req.getParameter("pw");
		System.out.println(password);

		try {
			String pw = getPw(userName);
			System.out.println(pw);
			if(userName.equals("") || password.equals("") || userName == null || password == null){
				resp.sendRedirect("signin?Err=");
			}
			else if(pw.equals(password)){
				resp.sendRedirect("success?userName="+userName);
			}
			else  {
				resp.sendRedirect("signin?Err=credwrong");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	

//
//	private boolean CheckUserExistence(String userName) throws SQLException {
//
//		String query = "SELECT 1 FROM users WHERE uname=?";
//		PreparedStatement pd =conn.prepareStatement(query);
//		pd.setString(1,userName);
//		ResultSet rs = pd.executeQuery();
//		if(rs.next()) {pd.close(); return true;}
//		else  {pd.close(); return false;}
//	}

	private  String getPw(String userName) throws  SQLException{
		String query = "SELECT pw FROM users WHERE uname=?";
		PreparedStatement pd =conn.prepareStatement(query);
		pd.setString(1,userName);
		ResultSet rs = pd.executeQuery();
		if(rs.next()){
			return rs.getString("pw");
		}else {
			return  "";
		}
	}

}
	