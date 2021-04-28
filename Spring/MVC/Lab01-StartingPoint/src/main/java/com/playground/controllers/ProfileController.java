package com.playground.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet
public class ProfileController  extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{  

    

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/e.jprofilsp");

        req.setAttribute("welcome", "From The Profile Servlet");
        rd.forward(req, res);
        
    }
}  
    
