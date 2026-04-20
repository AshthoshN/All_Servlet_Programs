import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        Cookie[] cookies = request.getCookies();

        int visitCount = 0;
        boolean found = false;

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("user")) {
                    name = c.getValue();
                    found = true;
                }

                if (c.getName().equals("count")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        visitCount++;

        Cookie nameCookie = new Cookie("user", name);
        Cookie countCookie = new Cookie("count", String.valueOf(visitCount));

        // 🔥 EXPIRY (60 seconds demo)
        nameCookie.setMaxAge(60);
        countCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        out.println("<html><body>");

        if (found) {
            out.println("<h2>Welcome back " + name + "!</h2>");
        } else {
            out.println("<h2>Hello " + name + "!</h2>");
        }

        out.println("<p>You have visited this page " + visitCount + " times.</p>");
        out.println("<p>(Refresh within 60 sec to see count increase)</p>");
        out.println("<p>(Wait 60 sec → cookie expires → count resets)</p>");

        out.println("</body></html>");
    }
}