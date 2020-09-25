package com.example.freeedu.entities;

import android.icu.util.LocaleData;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Task {
    private long id;
    private String description;
    private LocaleData deadline;
    private Lesson lesson;
    private Student studentWithPersonalTask;
    private ArrayList<Solution> solutions;

    public Task(String description, LocaleData deadline, Lesson lesson) {
        this.description = description;
        this.deadline = deadline;
        this.lesson = lesson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocaleData getDeadline() {
        return deadline;
    }

    public void setDeadline(LocaleData deadline) {
        this.deadline = deadline;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudentWithPersonalTask() {
        return studentWithPersonalTask;
    }

    public void setStudentWithPersonalTask(Student studentWithPersonalTask) {
        this.studentWithPersonalTask = studentWithPersonalTask;
    }

    public ArrayList<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Solution> solutions) {
        this.solutions = solutions;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Task guest = (Task) obj;
        return ((description.equals(guest.getDescription())) && (deadline.equals(guest.getDeadline()))
        );
    }
}
