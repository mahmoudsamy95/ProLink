package com.example.ea.prolink;


/**
 * Created by ea on 6/5/2018.
 */

public class Instructor {
    private String name;
    private int photo;

    public Instructor(String name) {
        this.name = name;
    }

    public Instructor() {
    }

    public Instructor(int photo) {
        this.photo = photo;
    }

    public Instructor(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
