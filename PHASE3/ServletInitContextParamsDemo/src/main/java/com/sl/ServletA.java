package com.sl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

//@WebServlet("/init-demo")
public class ServletA extends HttpServlet {
    String contentOfFile = null;

    public void init(ServletConfig config) {
//        contentOfFile = Files.readString(Path.of("a.txt"));
        try {
            String myFile = config.getInitParameter("filePathA");
            contentOfFile = Files.readString(Path.of(myFile));
        } catch (IOException e) {
            System.out.println(e);
        }

       System.out.println(" File content : " + contentOfFile);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        System.out.println("Inside doGet()");

        out.println(" File content : " + contentOfFile);
        out.close();
    }


}
