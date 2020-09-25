package com.example.freeedu.dao;

import com.example.freeedu.entities.Course;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CourseDаo extends AbstractDao{
    Gson gson;

    public CourseDаo() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Course getEntity(String json) {
        Course course = gson.fromJson(json, Course.class);
        return course;
    }

    public Course[] getAll(String json) {
        Course[] courses = gson.fromJson(json, Course[].class);

        return courses;
    }
}
