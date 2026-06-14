package com.sl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-c")
public class ServletC extends HttpServlet {
    int visitCount = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sessionIdentifier = request.getParameter("session-str");

        if(sessionIdentifier == null ){
            out.printf("<br>  Visitor, look like your a new visitior,"
                    + " since there was no session identier in your request");
            sessionIdentifier =  com.cl.utils.Utils.createUserSessionIdentifier();
            ++visitCount;
        }else{
            out.printf("<br>  Visitor, look like you had already visted some servlets on this website earlier,"
                    + "since there was a session identier in your request " + " you have visited %s times", ++visitCount);

        }

        out.printf("<br> <a href='servlet-a?session-str=%s' > Servlet A </a> ",sessionIdentifier );
        out.printf("<br> <a href='servlet-b?session-str=%s' > Servlet B </a> ",sessionIdentifier );

        out.close();
    }

}
