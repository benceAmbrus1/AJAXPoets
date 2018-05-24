package com.codecool.web.model;

public class User extends AbstractModel {

    private String name;
    private String email;
    private String pass;

    public User(int id, String name, String email, String pass) {
        super(id);
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
