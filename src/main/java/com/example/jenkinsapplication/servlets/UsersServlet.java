package com.example.jenkinsapplication.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "UsersServlet", value = "/UsersServlet")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.2.202:5432/postgres",
                    "postgres", "postgres");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            printWriter.println("<html>");
            while (resultSet.next()) {
                printWriter.println("<h2>" + resultSet.getString("name")
                        + resultSet.getString("surname")
                        + resultSet.getInt("age")+ "</h2>");
            }
            printWriter.println("</html>");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
