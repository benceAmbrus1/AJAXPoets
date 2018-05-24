package com.codecool.web.dao;

import com.codecool.web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao extends AbstractDao {

    public UserDao(Connection connection) {
        super(connection);
    }

    public User getUserByName(String email) throws SQLException {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        String sql = "SELECT id, name, email, password FROM users WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createUser(resultSet);
                }
            }
        }
        return null;
    }

    public User createUser(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String pass = resultSet.getString("password");
        return new User(id, name, email, pass);
    }
}
