package com.example.jenkinsapplication.controller.commands;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
    }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String jsp) throws ServletException, IOException {
        jsp = String.format("/%s.jsp", jsp);
        RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    protected void redirectToList() throws IOException {
        response.sendRedirect("/front-controller?command=List");
    }
}
