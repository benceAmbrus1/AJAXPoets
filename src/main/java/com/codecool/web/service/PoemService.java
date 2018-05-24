package com.codecool.web.service;

import com.codecool.web.dao.PoemDao;
import com.codecool.web.model.Poem;

import java.sql.SQLException;
import java.util.List;

public class PoemService {

    private PoemDao db;

    public PoemService(PoemDao db) {
        this.db = db;
    }

    public List<Poem> getPoemsById(int id) throws SQLException{
        return db.getAllPoemsByUserId(id);
    }
}
