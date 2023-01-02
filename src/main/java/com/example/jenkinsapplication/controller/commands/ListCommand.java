package com.example.jenkinsapplication.controller.commands;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        UserDao userDao = UserDao.getInstance();
        List<User> users = userDao.list();
        HttpSession session = request.getSession();
        session.setAttribute("users", users);
        forward("list");
    }
}
