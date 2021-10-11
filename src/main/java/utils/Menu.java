package utils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Menu", value = "/Menu")
public class Menu extends SessionChecker {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validate(request,response);

        if (request.getParameter("users")!=null){
            request.getRequestDispatcher("WEB-INF/views/users.jsp").forward(request, response);
        }

        if (request.getParameter("clients")!=null){
            request.getRequestDispatcher("WEB-INF/views/clients.jsp").forward(request, response);
        }
        if (request.getParameter("providers")!=null){
            request.getRequestDispatcher("WEB-INF/views/providers.jsp").forward(request, response);
        }
        if (request.getParameter("products")!=null){
            request.getRequestDispatcher("WEB-INF/views/products.jsp").forward(request, response);
        }
        if (request.getParameter("sales")!=null){
            request.getRequestDispatcher("WEB-INF/views/sales.jsp").forward(request, response);
        }
        if (request.getParameter("reports")!=null) {
            request.getRequestDispatcher("WEB-INF/views/reports.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
