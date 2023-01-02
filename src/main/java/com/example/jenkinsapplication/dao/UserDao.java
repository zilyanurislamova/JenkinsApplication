package com.example.jenkinsapplication.dao;

import com.example.jenkinsapplication.connection.DBConnection;
import com.example.jenkinsapplication.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao instance;
    private static final Connection connection = DBConnection.getConnection();

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> list() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User read(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setAge(resultSet.getInt("age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, surname, age) VALUES(?,?,?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET name=?, surname=?, age=? WHERE id=?");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
