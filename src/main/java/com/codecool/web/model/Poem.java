package com.codecool.web.model;

public class Poem extends AbstractModel{

    private String title;
    private String poem;

    public Poem(int id, String title, String poem) {
        super(id);
        this.title = title;
        this.poem = poem;
    }

    public String getTitle() {
        return title;
    }

    public String getPoem() {
        return poem;
    }
}
