package com.example.ea.prolink;

/**
 * Created by ea on 6/5/2018.
 */

public class Post {
    private String content;
  //  private Instructor instructor;
 //   private int photo;
    private String id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post(String content,String id) {

        this.content = content;
        this.id = id;
    }

    // a7san n3ml user w leeh type sa7?



   /* public Post(String content, int photo, String name) {
        this.content = content;
        this.photo = photo;
        this.name = name;
    }

    public Post() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
