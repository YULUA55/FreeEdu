package com.example.freeedu.model;

import com.example.freeedu.entities.Lesson;

import java.util.List;

public class ScheduleModel {
    List<Lesson> lessons;

    public ScheduleModel(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
