import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");

        int s1 = Integer.parseInt(request.getParameter("s1"));
        int s2 = Integer.parseInt(request.getParameter("s2"));
        int s3 = Integer.parseInt(request.getParameter("s3"));
        int s4 = Integer.parseInt(request.getParameter("s4"));
        int s5 = Integer.parseInt(request.getParameter("s5"));

        // Server-side validation
        if (roll.isEmpty() || name.isEmpty()) {
            response.getWriter().println("Invalid Input!");
            return;
        }

        int total = s1 + s2 + s3 + s4 + s5;
        double avg = total / 5.0;

        String result = (s1>40 && s2>40 && s3>40 && s4>40 && s5>40) ? "PASS" : "FAIL";

        request.setAttribute("roll", roll);
        request.setAttribute("name", name);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
