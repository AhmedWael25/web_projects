package com.playground;

import jakarta.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import jakarta.servlet.http.*;

public class DownloadServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;


	public void init(ServletConfig config) throws ServletException {
		this.config = config;

		ServletContext servletContext = config.getServletContext();
		conn = (Connection)servletContext.getAttribute("dbconn");
	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
            
            PrintWriter out = resp.getWriter();
            
            String fileName = "downloadedFile.txt";
            String filePath = "C:\\webdev\\web_projects\\Servlets&JSP\\";
            
            resp.setContentType("APPLICATION/OCTET-STREAM");
            resp.setHeader("Content-Disposition", "attachement;filename="+fileName);
            
            FileInputStream fis = new FileInputStream(filePath+fileName);
            
            int i ;
            while ( ( i = fis.read() )!= -1 ){
                out.write(i);
            }
            fis.close();
            out.close();
            
                
	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{


	}
	


}
	