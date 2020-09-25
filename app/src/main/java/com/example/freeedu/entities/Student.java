package com.example.freeedu.entities;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Student {
    private long id;
    private String name;
    private String surname;
    private String email;
    private ArrayList<Course> courses;
    private ArrayList<Solution> solutions;
    private ArrayList<Task> personalTasks;

    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public ArrayList<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Solution> solutions) {
        this.solutions = solutions;
    }

    public ArrayList<Task> getPersonalTasks() {
        return personalTasks;
    }

    public void setPersonalTasks(ArrayList<Task> personalTasks) {
        this.personalTasks = personalTasks;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Student guest = (Student) obj;
        return ((name.equals(guest.getName())) && (surname.equals(guest.getSurname())) && (email.equals(guest.getEmail()))
        );
    }

}
