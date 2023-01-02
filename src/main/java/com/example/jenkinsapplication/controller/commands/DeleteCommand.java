package com.example.jenkinsapplication.controller.commands;

import com.example.jenkinsapplication.dao.UserDao;

import javax.servlet.ServletException;
import java.io.IOException;

public class DeleteCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = UserDao.getInstance();
        userDao.delete(id);
        redirectToList();
    }
}
