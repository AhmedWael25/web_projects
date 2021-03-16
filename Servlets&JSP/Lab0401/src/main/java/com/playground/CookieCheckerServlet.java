package com.playground;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CookieCheckerServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;


	public void init(ServletConfig config) throws ServletException {
		this.config = config;

		ServletContext servletContext = config.getServletContext();
		conn = (Connection)servletContext.getAttribute("dbconn");
	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		
		System.out.println("Check again ");
		//Code to check if the user is a first timer or just cookies are disabled
		PrintWriter out = resp.getWriter();

		//Retrieve the cookie
		String isChecked = req.getParameter("chkd");
		//if isChecked is not null, we are in the second time
		///meaning we have already chkd it's existense before
		if(isChecked != null){
			Cookie[] cookies = req.getCookies();
			if(cookies != null){
				for(int i = 0 ; i < cookies.length;i++){
					Cookie cookie = cookies[i];
					System.out.println("Cookie Name: "+cookie.getName());
					System.out.println("Cookie Val: "+cookie.getValue());
				}
				resp.sendRedirect("signinreg");
			}else {
				resp.setContentType("text/html");
				out.println("<center>");
				out.println("<h1> You have your cookies disabled, Please enable then refresh the page </h1>");
				out.println("<h5> <a href='/cookieexamples/cookiechecker'>Refresh me !</a></h5>");
				out.println("</center>");
			}

		}else {
			//Create the dummy cookie
			Cookie myDummyCookie = new Cookie("dummy","dummy");
			//add to Resp(should be fist thing added)
			resp.addCookie(myDummyCookie);
			//Send Redirect
		resp.sendRedirect("cookiechecker?chkd=");
		}


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
	