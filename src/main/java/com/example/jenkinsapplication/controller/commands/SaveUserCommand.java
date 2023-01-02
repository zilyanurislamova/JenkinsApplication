package com.example.jenkinsapplication.controller.commands;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

public class SaveUserCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, surname, age);
        UserDao userDao = UserDao.getInstance();
        userDao.save(user);
        redirectToList();
    }
}
