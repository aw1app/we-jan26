package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = { "/RequestHeaderDemo", "/request-header-demo", "/h/*" })
public class RequestHeaderDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Enumeration<String> reqHeadersNames =  request.getHeaderNames();

        while(reqHeadersNames.hasMoreElements())
            System.out.println("header  = "  + reqHeadersNames.nextElement());

        String userAgent = request.getHeader("User-Agent");

        System.out.println("userAgent = "  + userAgent);

        out.println("Thank you, we noted your headers. Will get back to you");
        out.println("User-agent header value was : "+ userAgent);

        out.close();
    }

}

