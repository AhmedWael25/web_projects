package com.playground;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;


class Message{
	int id;
	String name;
	String msg;

	public Message(int id, String name, String msg) {
		this.id = id;
		this.name = name;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", name='" + name + '\'' +
				", msg='" + msg + '\'' +
				'}';
	}
}

public class ChatServlet extends HttpServlet{
	
	ServletConfig config;
	Connection conn;

	 static Vector<Message> messages = new Vector<>();
	AtomicInteger globalId = new AtomicInteger();

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		globalId.set(0);

		ServletContext servletContext = config.getServletContext();
		conn = (Connection)servletContext.getAttribute("dbconn");
	}


	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		PrintWriter out = resp.getWriter();
		JsonArrayBuilder arrBuilder  =  Json.createArrayBuilder();

		for (Message m: messages) {
			arrBuilder.add(Json.createObjectBuilder().add("id",m.id).add("name",m.name).add("msg",m.msg).build());
		}
		out.print(arrBuilder.build().toString());

	}

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

		String name = req.getParameter("name");
		String msg = req.getParameter("msg");

		Message newMsg = new Message(globalId.incrementAndGet(),name,msg);
		messages.add(newMsg);

		System.out.println(newMsg);

	}
	


}
	