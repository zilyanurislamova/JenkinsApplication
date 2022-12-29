package com.example.jenkinsapplication.servlets;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = UserDao.getInstance();
        User user = userDao.getUser(id);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);

        UserDao userDao = UserDao.getInstance();
        userDao.update(id, user);
        response.sendRedirect("/users-list");
    }
}
