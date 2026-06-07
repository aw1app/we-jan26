package org.example;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/lc-demo")
public class ServletLifeCycleDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int noOfVistors= 0;

    public ServletLifeCycleDemo() {
        System.out.println("Inside DemoServlet() constructor");
    }

    public void init() {
        System.out.println("Inside init()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Inside doGet()");
        System.out.println("Visitor no : " + (noOfVistors++));
    }

    public void destroy() {
        System.out.println("Inside destroy()");
    }

}
