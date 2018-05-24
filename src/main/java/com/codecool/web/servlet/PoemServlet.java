package com.codecool.web.servlet;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.User;
import com.codecool.web.service.PoemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/poems")
public class PoemServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection c = getConnection(req.getServletContext())){
            PoemDao db = new PoemDao(c);
            PoemService service = new PoemService(db);
            User user = (User) req.getSession().getAttribute("user");
            int id = user.getId();

            sendMessage(resp, HttpServletResponse.SC_OK, service.getPoemsById(id));

        } catch (SQLException e){

        }
    }
}
