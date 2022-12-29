package com.example.jenkinsapplication.servlets;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);
        UserDao userDao = UserDao.getInstance();
        userDao.save(user);
        response.sendRedirect("users-list");
    }
}
