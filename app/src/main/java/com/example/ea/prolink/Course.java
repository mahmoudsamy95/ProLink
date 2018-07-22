package com.example.ea.prolink;

/**
 * Created by ea on 6/7/2018.
 */

public class Course {
    String courseName;
    String courseId;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        this.courseId=courseId;

    }

    public Course(String courseName,String courseId) {

        this.courseName = courseName;
        this.courseId = courseId;
    }
/*int courseIcon;

    public Course() {
    }

    public Course(String courseName, int courseIcon) {
        this.courseName = courseName;
        this.courseIcon = courseIcon;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseIcon() {
        return courseIcon;
    }

    public void setCourseIcon(int courseIcon) {
        this.courseIcon = courseIcon;
    }*/
}
