package com.example.ea.prolink;

/**
 * Created by mahmoud on 7/7/2018.
 */

public class Assignment {
    String name,description,due;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public Assignment(String name,String description,String due) {

        this.name = name;
        this.description = description;
        this.due = due;
    }
}
