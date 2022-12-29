package com.example.jenkinsapplication.servlets;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet", value = "/users-list")
public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> users = userDao.list();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
