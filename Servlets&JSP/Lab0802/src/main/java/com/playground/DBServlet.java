package com.playground;

//import jakarta.enterprise.context.spi.*;
import jakarta.servlet.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBServlet  implements Servlet {
    ServletConfig config;
    Connection conn;
    public void init(ServletConfig config){
        this.config = config;
        try {

            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ecomm");
            conn = ds.getConnection();

            ServletContext servletContext = config.getServletContext();
            servletContext.setAttribute("dbconn",conn);

            System.out.println(conn);

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

}
