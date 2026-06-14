import java.io.IOException;
import java.io.PrintWriter;

import com.sl.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet-B")
public class ServletB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
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
        out.printf("<h2> Your are in servlet B </h2> "); // user will see this message. Why?


        out.close();
    }

}