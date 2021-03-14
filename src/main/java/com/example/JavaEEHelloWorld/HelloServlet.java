package com.example.JavaEEHelloWorld;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(description = "Our First Servlet", urlPatterns = { "/first" }, initParams = {@WebInitParam(name = "jdbcDriver", value = "someOtherDbDriver")})
public class HelloServlet extends HttpServlet {
    private String message;
    @Override
    public void init() throws ServletException {
        System.out.println("init() called...");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        //		Fetch values from the request
        String userName = request.getParameter("userName");
        String userAddress = request.getParameter("userAddress");

        if(userName.trim().equals("admin")) {
//			Get a reference to the RequestDispatcher
            RequestDispatcher theDispatcher = request.getRequestDispatcher("other");


            //response.getWriter().println("Welcome Admin to your home page...");

            //			Forward the request
//			theDispatcher.forward(request, response);
            theDispatcher.include(request, response);

        }
        else {
//			Redirect back to the home page
//			response.sendRedirect("index.html");
            RequestDispatcher theDispatcher = request.getRequestDispatcher("index.html");

            response.getWriter().println("Invalid username, please login with the right credentials...");

            theDispatcher.include(request, response);


//			response.getWriter().println("Invalid username...");
        }

//		response.getWriter().println("Welcome : " + userName + ", your address is : " + userAddress);
    }

//	Automatically called for get type of requests
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doGet() called...");// Displays on the console
//
////		Set the content type
//		resp.setContentType("text/html");
//
////		Get a reference to the PrintWriter object
//		PrintWriter out = resp.getWriter();
//
////		Write something back to the client
//		out.println("<h2>Welcome client, we are processing your request now...</h2>");
//	}
//
//
////	This method is automatically called for post type of requests
//	@Override //Optional but recommended
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
//	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//
////		Get a reference to the ServletConfig object
//	 	ServletConfig config = getServletConfig();
//
////	 	Get params out of the config for this servlet
//	 	String dbDriver = config.getInitParameter("jdbcDriver");
//
//	 	System.out.println("Driver : " + dbDriver);
//
//
////		try {
////			Class.forName(dbDriver);
////		} catch (ClassNotFoundException e) {
////			System.out.println("Can't load the Driver : " + e.getMessage());
////		}
////
//
//
//		System.out.println("Inside service() now...");
//
//		//		Set the content type
//		resp.setContentType("text/html");
//
////		Get a reference to the PrintWriter object
//		PrintWriter out = resp.getWriter();
//
////		out.println("service() handles both types of requests");
//
//		out.println("Servlet Name : " + config.getServletName());
////		out.println("Servlet Name : " + config.getServletContext());
//	}


    @Override
    public void destroy() {
        System.out.println("inside destroy()...");
    }

}