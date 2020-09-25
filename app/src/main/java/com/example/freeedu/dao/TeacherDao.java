package com.example.freeedu.dao;

import com.example.freeedu.entities.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TeacherDao extends AbstractDao {
    Gson gson;

    public TeacherDao() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Teacher getEntity(String json) {
        Teacher teacher = gson.fromJson(json, Teacher.class);

        return teacher;
    }

    public Teacher[] getAll(String json) {
        Teacher[] teachers = gson.fromJson(json, Teacher[].class);

        return teachers;
    }


}
