
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDataServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String desig = request.getParameter("designation");

        if (name == null || email == null || desig == null ||
            name.isEmpty() || email.isEmpty() || desig.isEmpty()) {

            response.getWriter().println("Invalid Input! All fields required.");
            return;
        }

        // pass data to JSP
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("desig", desig);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}