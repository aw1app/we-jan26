import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet-A")
public class ServletA extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sessionIdentifier = request.getParameter("session-str");

        // check if there is a session string this request
        if (sessionIdentifier == null) {
            sessionIdentifier = Utils.createUserSessionIdentifier();
            out.printf("<br>  Visitor, look like your a new visitior,"
                    + " since there was no session identier in your request");
        } else {
            out.printf("<br>  Visitor, look like you had already visted some servlets on this website earlier,"
                    + "since there was a session identier in your request ");
        }

        // response
        out.printf("<h2> Your are being taken to servlet B </h2> "); // user may not see this message. Why?

        out.printf("<br> <form action='servlet-B' method='POST' >  ");
        out.printf("<input type='hidden' name='session-str' value='%s'> ", sessionIdentifier);
        out.printf("</form>");
        out.printf("<script>document.forms[0].submit();</script>");

        out.close();
    }

}
