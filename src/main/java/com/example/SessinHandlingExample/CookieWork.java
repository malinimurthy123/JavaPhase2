package com.example.SessinHandlingExample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookies")
public class CookieWork extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        //		Create a Cookie
        Cookie theCookie = new Cookie("companyName", "Simplilearn");

//		Set the expiry of this cookie
        theCookie.setMaxAge(3600);

//		Add this cookie to the response
        response.addCookie(theCookie);


//		Fetch the value from the cookie
        response.getWriter().println(theCookie.getValue() + "<br>");
        response.getWriter().println(theCookie.getName());
    }

}
