package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        request.setAttribute("logout", logout);
        
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountService newAccount = new AccountService();
        String username = request.getParameter("username");
        request.setAttribute("username", username);
        String password = request.getParameter("password");
        request.setAttribute("password", password);
        
        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "Missing credentials.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (newAccount.login(username, password) != null) {
            session.setAttribute("username", username);
            response.sendRedirect("home");
        } else {
            request.setAttribute("message", "Incorrect credentials.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }    
    }
}
