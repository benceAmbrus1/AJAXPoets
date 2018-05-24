package com.codecool.web.service;

import com.codecool.web.dao.UserDao;
import com.codecool.web.model.User;
import com.codecool.web.service.exceptions.BadLoginException;

import java.sql.SQLException;

public class UserService {

    private final UserDao db;

    public UserService(UserDao db) {
        this.db = db;
    }

    public User getUser(String email, String pass) throws BadLoginException, SQLException{
        if(email==null||email.equals("")||pass==null||pass.equals("")){
            throw new BadLoginException("Bad Login");
        }

        User user = db.getUserByName(email);

        if( user==null || !user.getPass().equals(pass)){
            throw new BadLoginException("Bad Login");
        }
        return user;
    }
}
