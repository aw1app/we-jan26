package com.sl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-B")
public class ServletB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if there is a http session object else create one
        HttpSession session = request.getSession(false); // false means don't create a session if it does not exist

        if (session == null) {
            // Visitor has come to this web app first time
            out.printf("<br>InSIDE Servlet B:   Visitor, look like your a new visitior,"
                    + " since there was no session identier in your request");
            session = request.getSession(true); // true create a new session object if it did not exist
        } else {
            // Visitor has come to this web app some time back
            out.printf("<br> InSIDE Servlet A:  Visitor, look like you had already visted some servlets on this website earlier,"
                    + "since there was a session identier (%s) in your request ", session.getId());
        }


        // do something more with session object
        Integer userVisitCounter = (Integer) session.getAttribute("visit-count");

        if(userVisitCounter==null)userVisitCounter=1;
        else
            userVisitCounter++;

        session.setAttribute("visit-count", userVisitCounter);

        out.printf("<br> InSIDE Servlet B: You have visted this website %d time(s)", userVisitCounter);

        out.close();
    }


}
