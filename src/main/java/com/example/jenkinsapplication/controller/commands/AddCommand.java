package com.example.jenkinsapplication.controller.commands;

import javax.servlet.ServletException;
import java.io.IOException;

public class AddCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException {
        forward("add");
    }
}