package com.sl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServletB extends HttpServlet {
    String param_b_1 = null;

    public void init(ServletConfig config) {
        try {
            // Config params are read from ServletConfig object
            param_b_1 = config.getInitParameter("param_b_1");
            System.out.println("param_b_1 = "+param_b_1);


            // Context params are read from Servletcontext object
            String common_param_1 = config.getServletContext().getInitParameter("common_param_1");
            System.out.println("common_param_1 = "+common_param_1);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        System.out.println("Inside doGet()");

        out.println(" param_b_1 : " + param_b_1);
        out.close();
    }


}
