package com.example.SessinHandlingExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/s")
public class SessionWork extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Get a reference to the HttpSession object
        HttpSession theSession = request.getSession();

//		Save a value in the session
        theSession.setAttribute("userId", "689");

    }

}
