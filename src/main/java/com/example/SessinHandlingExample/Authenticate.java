package com.example.SessinHandlingExample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Set the content type
        response.setContentType("text/html");

//		Get the writer
        PrintWriter out = response.getWriter();

//		Fetch the value from the hidden form field, which was sent along this request
        String id =request.getParameter("userId");

        System.out.println("ID : " + id);


        //		Fetch the values from Request
        String userName = request.getParameter("userName");
//		String userPassword = request.getParameter("userPass");

//		Get a reference to the Session
        HttpSession theSession = request.getSession();

//		Get a reference to the ServletContext object
        ServletContext theContext = getServletContext();

//		Check whether parameters exists in the request
        if(userName !=  null) {
//			Save the userName(coming from the request) into the session
            theSession.setAttribute("uName", userName);

//			Save the userName(coming from the request) into the context
            theContext.setAttribute("uName", userName);

        }

//		Print userName from request
        out.println("<h3>From Request, username : " + userName + "<br>");

//		Print userName from session
        out.println("From session, username : " + theSession.getAttribute("uName") + "<br>");

//		Print userName from context
        out.println("From context, username : " + theContext.getAttribute("uName") + "</h3>");
    }

}
