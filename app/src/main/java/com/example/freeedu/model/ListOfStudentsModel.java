package com.example.freeedu.model;

import com.example.freeedu.entities.Student;

import java.util.List;

public class ListOfStudentsModel {
    List<Student> students;

    public ListOfStudentsModel(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
