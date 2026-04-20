import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get session
        HttpSession session = request.getSession();

        // Set session timeout (60 sec)
        session.setMaxInactiveInterval(60);

        Integer count = (Integer) session.getAttribute("visitCount");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("visitCount", count);

        out.println("<h2>Session Tracking Info</h2>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Creation Time: " + new Date(session.getCreationTime()) + "<br>");
        out.println("Last Access Time: " + new Date(session.getLastAccessedTime()) + "<br>");
        out.println("Visit Count: " + count + "<br>");

        out.println("<br><a href='SessionServlet'>Refresh</a>");
    }
}