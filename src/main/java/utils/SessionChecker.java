package utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionChecker", value = "/SessionChecker")
public class SessionChecker extends HttpServlet {
    protected void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("CURRENT_USER") == null){
            request.setAttribute("error", "No has iniciado sessión.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
