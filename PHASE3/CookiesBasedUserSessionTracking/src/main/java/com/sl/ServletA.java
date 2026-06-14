package com.sl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-A")
public class ServletA extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if there is a session identifier in one of the cookies else create one
        Cookie[] cookies = request.getCookies();

        String sessionIdentifierStr = null;

        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("session-str")) {

                    sessionIdentifierStr = cookie.getValue();

                    out.printf("<br> InSIDE Servlet A:  Visitor, look like you had already visted some servlets on this website earlier,"
                            + "since there was a session identier (%s) in your request ", sessionIdentifierStr);
                }
            }
        ;

        if (sessionIdentifierStr == null) {
            out.printf("<br>InSIDE Servlet A:   Visitor, look like your a new visitior,"
                    + " since there was no session identier in your request");

            sessionIdentifierStr = com.cl.utils.Utils.createUserSessionIdentifier();

            Cookie sessionCookie = new Cookie("session-str", sessionIdentifierStr);
            response.addCookie(sessionCookie);
        }
        ;


        out.close();
    }


}