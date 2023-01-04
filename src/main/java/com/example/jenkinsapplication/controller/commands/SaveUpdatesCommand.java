package com.example.jenkinsapplication.controller.commands;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveUpdatesCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);
        UserDao userDao = new UserDao();
        userDao.update(id, user);
        redirectToList();
    }
}
