package com.playground;

import com.playground.model.User;
import jakarta.enterprise.inject.New;
import jakarta.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;

		ServletContext servletContext = config.getServletContext();
		conn = (Connection)servletContext.getAttribute("dbconn");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");

		out.println("<center>");
		out.println("<h1 style='margin:50px auto;'>Registeration Form</h1>");
		out.println("<h4 style='margin:20px auto;'>Enter Your Details</h4>");

		String str = req.getParameter("Err");
		if(str != null){
			if(str.equals("")){
				out.println("<h5 style='margin:10px auto; color:red;'>The Form was invalid, Check your form and try again</h5>");
			}else {
				out.println("<h5 style='margin:10px auto; color:red;'>User Exists, Change userName</h5>");
			}
		}


		out.println("<FORM action='register' method= POST>");


		out.println("<div style='margin:50px auto;>");
		out.println("<label for='fname' style='font-size:20px;margin-right:10px;'>FirstName : </label>");
		out.println("<INPUT TYPE=TEXT NAME=fname><BR>");
		out.println("</div>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='lname' style='font-size:20px;margin-right:10px;'>Lastname : </label>");
		out.println("<INPUT TYPE=TEXT NAME=lname><BR>");
		out.println("</div>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='userName' style='font-size:20px;margin-right:10px;'>Username : </label>");
		out.println("<INPUT TYPE=TEXT NAME=userName><BR>");
		out.println("</div>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='userName' style='font-size:20px;margin-right:10px;'>Password : </label>");
		out.println("<INPUT TYPE=PASSWORD	NAME=password><BR>");
		out.println("</div>");

		out.println("<BR> <INPUT style='background-color:cyan;color:white;font-size20px;' TYPE=SUBMIT VALUE=Submit><BR>");

		out.println("</FORM>");


		out.println("</center>");
	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		String fname 	= req.getParameter("fname");
		String lname 	= req.getParameter("lname");
		String userName = req.getParameter("userName");
		String pw 		= req.getParameter("password");

		boolean isValid = CheckValidity(fname,lname,userName,pw);
		boolean isUserExist = false;
		try {
			isUserExist = CheckUserExistence(userName);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


		if(!isValid){
			//if not valid redirect to register again with error MSG
			resp.sendRedirect("register?Err=");
		}
		else if(isUserExist){
			//if User exists redirect to register
			resp.sendRedirect("register?Err=ex");
		}else{
			//if All Good register
			User newUser  = new User();
			newUser.setFname(fname);
			newUser.setLname(lname);
			newUser.setUserName(userName);
			newUser.setPassword(pw);
			try {
				registerUser(newUser);
				resp.sendRedirect("signin");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}

	private boolean CheckUserExistence(String userName) throws SQLException {

		String query = "SELECT 1 FROM users WHERE uname=?";
		PreparedStatement pd =conn.prepareStatement(query);
		pd.setString(1,userName);
		ResultSet rs = pd.executeQuery();
		if(rs.next()) {pd.close(); return true;}
		else  {pd.close(); return false;}
	}

	private  boolean registerUser(User newUser) throws SQLException {
		String query = "INSERT INTO users(fname,lname,uname,pw) VALUES(?,?,?,?)";
		PreparedStatement pd =conn.prepareStatement(query);
		pd.setString(1, newUser.getFname());
		pd.setString(2, newUser.getLname());
		pd.setString(3, newUser.getUserName());
		pd.setString(4, newUser.getPassword());

		pd.executeUpdate();
		pd.close();
		return  true;
	}


	private boolean checkCredentials(String userName, String pw){
		
		final String user = "ahmed";
		final String upw = "123";
		

		if(userName == null || userName.equals("") || !userName.equals(user)) return false;
		if(pw == null || pw.equals("") || !pw.equals(upw)) return false;

		return true;
	}

	private boolean CheckValidity(String fname, String lname, String userName, String pw){

		if(fname.equals("") || fname == null){
			return false;
		}
		else if(lname.equals("") || lname == null){

			return false;
		}
		else if(userName.equals("") || userName == null){
			return false;
		}
		else if(pw.equals("") || pw == null){
			return false;
		}
		return true;

		}
}
	