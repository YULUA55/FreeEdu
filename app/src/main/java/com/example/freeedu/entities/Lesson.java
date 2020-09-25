package com.example.freeedu.entities;


import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lesson {
    private long id;
    private Course course;
    private String description;
    private LocalDate date;
    private ArrayList<Task> tasks;

    public Lesson(Course course, String description) {
        this.course = course;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setData(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lesson guest = (Lesson) obj;
        return ((course.equals(guest.getCourse())) && (description.equals(guest.getDescription()))
        );
    }
}
