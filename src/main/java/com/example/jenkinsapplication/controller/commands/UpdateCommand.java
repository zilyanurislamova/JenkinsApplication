package com.example.jenkinsapplication.controller.commands;

import com.example.jenkinsapplication.dao.UserDao;
import com.example.jenkinsapplication.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("user", user);
        forward("update");
    }
}
