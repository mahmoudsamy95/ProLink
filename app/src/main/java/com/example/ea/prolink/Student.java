package com.example.ea.prolink;

/**
 * Created by ea on 6/9/2018.
 */

public class Student {
    String name;
    String emai;
    String dob;
    String level;

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    String imgURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Student(String name,String emai,String dob,String level, String imgURL) {

        this.name = name;
        this.emai = emai;
        this.dob = dob;
        this.level = level;
        this.imgURL = imgURL;
    }
}
