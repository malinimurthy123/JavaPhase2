package com.example.JavaEEHelloWorld;

import java.io.*;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Fetch values from the request
        String userName = request.getParameter("userName");
        String userAddress = request.getParameter("userAddress");

        response.getWriter().println("Welcome : " + userName + ", your address is : " + userAddress);
    }



    @Override
    public void destroy() {
        System.out.println("inside destroy()...");
    }

}