package Login;

import Conexion.Conexion;
import usuarios.UsuariosDTO;
import utils.PasswordCrypto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("login-acc") != null) {
            String user, password, hashedPassword;
            user = request.getParameter("user");
            password = request.getParameter("password");

            if (user.equals("admininicial") && password.equals("admin123456")) {
                request.getSession().setAttribute("CURRENT_USER", "Admininical");
                request.getRequestDispatcher("WEB-INF/views/users.jsp").forward(request, response);
            } else {
                hashedPassword = PasswordCrypto.hashPassword(password);

                Conexion conn = new Conexion();
                Connection con = conn.connect();
                try {
                    UsuariosDTO logedInUser = UserSession.login(con, user, hashedPassword);
                    if (logedInUser != null) {
                        request.getSession().setAttribute("CURRENT_USER", logedInUser);
                        con.close();
                        request.getRequestDispatcher("WEB-INF/views/users.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error", "Usuario o contraseña incorrectos.");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    request.setAttribute("error", "Error: " + e);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        }
    }

}
