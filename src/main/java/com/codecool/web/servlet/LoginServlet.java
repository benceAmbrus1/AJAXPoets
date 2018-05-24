package com.codecool.web.servlet;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import com.codecool.web.service.exceptions.BadLoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            UserDao db = new UserDao(connection);
            UserService service = new UserService(db);

            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            User user = service.getUser(email, pass);

            req.getSession().setAttribute("user", user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("protected/main.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (BadLoginException ex){
            req.setAttribute("error", ex);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
}
