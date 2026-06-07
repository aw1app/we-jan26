package com.sl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/process-login")
public class FormProcessingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Extract form submision data
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        // retrieve the checkbox multi selection using getParameterValues
        String[] userTypes = req.getParameterValues("user-type");

        String specialities = req.getParameter("specialities");

        //for(String type: userTypes)
        //System.out.println(type);

        out.println("<br><i> Thanks for submitting your profile data </i>.");
        out.println("<br><br> You submitted name:" + userName + ",password = " + password
                + " and userTypes=" + Arrays.toString(userTypes));
        out.println("<br><br> Your specialities " + specialities);

        out.close();
    }
}
