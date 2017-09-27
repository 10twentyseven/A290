package com.a290.kevin.assignment4;

/**
 * Created by Kevin on 9/13/2017.
 */

public class ToDo {
    private String title;
    private String description;

    public ToDo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
