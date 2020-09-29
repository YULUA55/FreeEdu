package com.example.freeedu.model;

import com.example.freeedu.entities.Teacher;

public class TeacherMainModel {
    Teacher teacher;

    public TeacherMainModel(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
