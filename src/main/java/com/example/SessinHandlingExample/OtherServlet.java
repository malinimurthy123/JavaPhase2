package com.example.SessinHandlingExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/other")
public class OtherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Get a reference to the HttpSession
        HttpSession theSession = request.getSession();

//		Try to get the value from the session and display it on the browser
        response.getWriter().println("ID : " + theSession.getAttribute("userId"));

    }

}
