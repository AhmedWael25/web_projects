package com.playground;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SQLToolServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;


	public void init(ServletConfig config) throws ServletException {
		this.config = config;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","admin");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");



		out.println("<h1 style='margin:50px auto;'>SQL Tool</h1>");
		out.println("<h4 style='margin:20px auto;'>Enter your SQL Statement</h4>");

		String err = req.getParameter("Err");
		if(err != null){
			if(err.equals("unsupp")){
				out.println("<h5 style='margin:10px auto;color:red'>Statement UnSupported</h5>");
			}else {
				out.println("<h5 style='margin:10px auto;color:red'>Statement Invalid</h5>");
			}
		}else {
			out.println("<h5 style='margin:10px auto;color:red'></h5>");
		}


		out.println("<FORM action='sqltool'  method= get>");

		out.println("<div style='margin:50px auto;>");
		out.println("<label for='query' style='font-size:20px;margin-right:10px;'>SQL: </label><br>");
		out.println("<textarea cols=100 rows = 20 TYPE=TEXT NAME=query></textarea><br>");
		out.println("<BR> <INPUT style='background-color:cyan;color:white;font-size20px;' TYPE=SUBMIT VALUE=Submit><BR>");
		out.println("</div>");
		out.println("</FORM>");

		String query = req.getParameter("query");
		if(query != null){
			query = query.toLowerCase();
			System.out.println(query);
			try {
				if(query.startsWith("select")){
					executeSelectQuery(query, out);
				}else if(query.startsWith("create") ||query.startsWith("drop")){
					executeCreate(query,out);
				}
				else {
					executeQuery(query,out);
				}
			} catch (SQLException throwables) {
				//Invalid statement
				throwables.printStackTrace();
				resp.sendRedirect("sqltool?Err=");
			}
		}

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		String userName = req.getParameter("key");

	}
	

	private boolean executeSelectQuery(String query, PrintWriter out) throws  SQLException{

		PreparedStatement pd = conn.prepareStatement(query);
		ResultSet rs = pd.executeQuery();
		ResultSetMetaData rsMetaData = rs.getMetaData();

		out.println("<table style='width:50%'> <caption>Users</caption>");

		out.println("<tr>");
		for (int i = 1; i <= rsMetaData.getColumnCount(); i++){
			out.println("<th>"+rsMetaData.getColumnLabel(i)+"</th>");
		}
		out.println("</tr>");


		while(rs.next()){

			out.println("<tr>");
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++){
				out.println("<th>"+rs.getString(i)+"</th>");
			}
			out.println("</tr>");
		}

		out.println("</table>");
		return  true;
	}


	private boolean executeQuery(String query, PrintWriter out) throws  SQLException{
		PreparedStatement pd = conn.prepareStatement(query);
		int rowCount = pd.executeUpdate();

		out.println("<h4 style='margin:20px auto;color:green'>"+rowCount+" Rows Affected</h4>");
		return  true;
	}
	private boolean executeCreate(String query, PrintWriter out) throws  SQLException{
		PreparedStatement pd = conn.prepareStatement(query);
		pd.executeUpdate();

		if(query.startsWith("create")){

			out.println("<h4 style='margin:20px auto;color:green'>Table Created</h4>");
		}else {
			out.println("<h4 style='margin:20px auto;color:green'>Table Dropped</h4>");

		}
		return  true;
	}
}
	