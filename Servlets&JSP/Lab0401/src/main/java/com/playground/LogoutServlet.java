package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class LogoutServlet extends HttpServlet{
	
	ServletConfig config;



	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
	
		HttpSession session = req.getSession();
		session.invalidate();
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(int i = 0 ; i < cookies.length;i++){
				Cookie cookie = cookies[i];
				String name = cookie.getName();
				
				cookie = new Cookie(name, "");
				cookie.setMaxAge(-1);
				resp.addCookie(cookie);
			}
		}
		resp.sendRedirect("signin");
	}

}
	