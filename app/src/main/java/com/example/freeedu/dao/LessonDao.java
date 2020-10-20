package com.example.freeedu.dao;

import com.example.freeedu.entities.Lesson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class LessonDao extends AbstractDao {
    Gson gson;

    public LessonDao() {
        gson = new GsonBuilder().registerTypeAdapter(Lesson.class,new LessonSerializer()).create();
    }

    public Lesson getEntity(String json) {
        Lesson lesson = gson.fromJson(json,Lesson.class);
        return lesson;
    }

    public Lesson[] getAll(String json) {
        Lesson[] lessons = gson.fromJson(json, Lesson[].class);
        return lessons;
    }
}
