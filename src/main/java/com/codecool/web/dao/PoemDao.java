package com.codecool.web.dao;

import com.codecool.web.model.Poem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoemDao extends AbstractDao{

    public PoemDao(Connection connection) {
        super(connection);
    }

    public List<Poem> getAllPoemsByUserId(int id) throws SQLException{
        String sql = "SELECT id, title, poem FROM poems WHERE user_id = ?";
        List<Poem> poems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    poems.add(createPoem(resultSet));
                }
            }
        }
        return poems;
    }

    private Poem createPoem(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        String title = rs.getString("title");
        String poem = rs.getString("poem");
        return new Poem(id, title, poem);
    }
}
