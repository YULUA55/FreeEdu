package com.example.freeedu.entities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class Course {
    private long id;
    private String name;
    private String description;
    private Teacher teacher;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;

    public Course(String name, String description, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.teacher=teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Course guest = (Course) obj;
        return ((name.equals( guest.getName())) && (description.equals( guest.getDescription())) && (teacher.equals(guest.getTeacher()))
        );
    }

    @NonNull
    @Override
    public String toString() {
        return this.description+this.name+this.teacher.getName()+this.teacher.getEmail();
    }
}
