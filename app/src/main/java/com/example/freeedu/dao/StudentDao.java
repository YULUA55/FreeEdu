package com.example.freeedu.dao;

import com.example.freeedu.entities.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StudentDao extends AbstractDao {
    Gson gson;

    public StudentDao() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Student getEntity(String json) {
        Student student = gson.fromJson(json, Student.class);

        return student;
    }

    public Student[] getAll(String json) {
        Student[] students = gson.fromJson(json, Student[].class);

        return students;
    }

}
