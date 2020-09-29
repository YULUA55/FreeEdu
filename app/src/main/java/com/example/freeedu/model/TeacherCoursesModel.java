package com.example.freeedu.model;

import com.example.freeedu.entities.Course;

import java.util.List;

public class TeacherCoursesModel {

    List<Course> courses;

    public TeacherCoursesModel(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
