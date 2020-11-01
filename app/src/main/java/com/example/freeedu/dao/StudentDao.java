package com.example.freeedu.dao;

import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Student;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class StudentDao extends AbstractDao {
    private Gson gson;
    private BaseRequestResultListener listener;

    public StudentDao(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.listener = new BaseRequestResultListener(this);
    }

    @Override
    public void sendRequest() {

    }

    public Student getEntity(String json) {
        Student student = gson.fromJson(json, Student.class);

        return student;
    }

    public ArrayList<Student> getAll(String json) {
        Student[] students = gson.fromJson(json, Student[].class);
        ArrayList<Student> list = new ArrayList();
        Collections.addAll(list, students);

        return list;
    }

}
