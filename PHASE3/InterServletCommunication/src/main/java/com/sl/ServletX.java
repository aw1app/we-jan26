package com.sl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-x")
public class ServletX extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<br> RESPONSE-1 from servlet-x"); // this will NOT go to client, it is a waste to write this line

        response.sendRedirect(request.getContextPath()+ "/servlet-y");

        out.println("<br> RESPONSE-2 from servlet-x");// this will NOT go to client, it is a waste to write this line

        out.close();
    }

}