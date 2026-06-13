package com.sl.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class VoteFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("INSIDE doFilter() of VoteFilter");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int age = Integer.parseInt(request.getParameter("age"));

        if(age<18){
            out.print("You are under 18 and therefore not eligible to vote!");
            System.out.println("INSIDE VoteFilter's doFilter() of VoteFilter's if part");
            out.close();
        }else{
            System.out.println("INSIDE VoteFilter's doFilter() of VoteFilter's else part");
            chain.doFilter(request, response);
        }

        out.close();
    }

}
