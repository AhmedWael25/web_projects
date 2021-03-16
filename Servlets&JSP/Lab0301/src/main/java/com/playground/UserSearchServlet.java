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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSearchServlet extends HttpServlet{
	
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
		out.println("<h1 style='margin:50px auto;'>SEARCH Form</h1>");
		out.println("<h4 style='margin:20px auto;'>Enter First Name To start searching</h4>");

		out.println("<FORM action='search'  method= get>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='key' style='font-size:20px;margin-right:10px;'>Search : </label>");
		out.println("<INPUT TYPE=TEXT NAME=key><BR>");
		out.println("<BR> <INPUT style='background-color:cyan;color:white;font-size20px;' TYPE=SUBMIT VALUE=Submit><BR>");
		out.println("</div>");
		out.println("</FORM>");

		out.println("<table style='width:75%'> <caption>Users</caption>");

		out.println("<tr>\n" +
				"    <th>Firstname</th>\n" +
				"    <th>Lastname</th>\n" +
				"    <th>UserName</th>\n" +
				"    <th>Password</th>\n" +
				"  </tr>");

		String searchKey = req.getParameter("key");
		System.out.println("FROM GET"+searchKey);
		if(searchKey != null){
			try {
				populateTable(searchKey,out);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		out.println("</table>");

		out.println("</center>");

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{


		String userName = req.getParameter("key");


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
	private void populateTable(String key, PrintWriter out) throws  SQLException{

		key = key.replace("!", "!!")
				.replace("%", "!%")
				.replace("_", "!_")
				.replace("[", "![");
		String query = "SELECT * FROM users where fname LIKE ? ESCAPE'!'";
		PreparedStatement pd = conn.prepareStatement(query);
		pd.setString(1,key+"%");

		ResultSet rs = pd.executeQuery();

		while(rs.next()){
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String userName = rs.getString("uname");
			String pw = rs.getString("pw");

			System.out.println("FROM OMK"+fname+lname+userName+pw);

			out.println("<tr>\n" +
					"    <th>"+fname+"</th>\n" +
					"    <th>"+lname+"</th>\n" +
					"    <th>"+userName+"</th>\n" +
					"    <th>"+pw+"</th>\n" +
					"  </tr>");
		}
	}

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
	