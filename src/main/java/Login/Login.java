package Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login-acc") != null) {
            String user, password;
            user = request.getParameter("user");
            password = request.getParameter("password");

            if (user.equals("admininicial") && password.equals("admin123456")) {
                response.sendRedirect("users.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

}
