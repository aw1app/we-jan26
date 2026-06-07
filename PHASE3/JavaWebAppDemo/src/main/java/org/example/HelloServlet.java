package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.getWriter()
                .println("Hello Servlet");

        String userName = request.getParameter("name");
        String age = request.getParameter("age");

        response.getWriter()
                .println("Oh, your name is " + userName + " and age is "+ age);

        response.getWriter()
                .println("Have a great day! " );
    }
}