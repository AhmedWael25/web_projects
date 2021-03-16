package com.playground;

import com.playground.model.User;
import com.playground.model.UserBean;
import jakarta.servlet.RequestDispatcher;
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
import java.util.ArrayList;
import java.util.List;

public class UserSearchServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;


	public void init(ServletConfig config) throws ServletException {
		this.config = config;

//		ServletContext servletContext = config.getServletContext();
//		conn = (Connection)servletContext.getAttribute("dbconn");

		DBConnectionFactory dbConnectionFactory = DBConnectionFactory.getInstance();
		conn = dbConnectionFactory.getConnection();

	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		String searchKey = req.getParameter("key");
		System.out.println("FROM GET"+searchKey);
		if(searchKey != null){
			try {

				List<UserBean> users = populateTable(searchKey);

				req.setAttribute("result",users);

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");

				requestDispatcher.forward(req,resp);

			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}



	private List<UserBean> populateTable(String key) throws  SQLException{
		List<UserBean> users = new ArrayList<>();

		key = key.replace("!", "!!")
				.replace("%", "!%")
				.replace("_", "!_")
				.replace("[", "![");
		String query = "SELECT * FROM users where fname LIKE ? ESCAPE'!'";
		PreparedStatement pd = conn.prepareStatement(query);
		pd.setString(1,key+"%");

		ResultSet rs = pd.executeQuery();

		while(rs.next()){
			UserBean user = new UserBean();

			user.setFirstName(rs.getString("fname"));
			user.setLastName(rs.getString("lname"));
			user.setUserName(rs.getString("uname"));
			user.setPassword(rs.getString("pw"));
			users.add(user);
		}
		return  users;
	}



}
	