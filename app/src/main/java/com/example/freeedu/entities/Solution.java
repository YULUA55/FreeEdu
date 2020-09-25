package com.example.freeedu.entities;

import androidx.annotation.Nullable;

public class Solution {
    private long id;
    private String answer;
    private int mark;
    private Task task;
    private Student student;

    public Solution(String answer, Task task, Student student) {
        this.answer = answer;
        this.task = task;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Solution guest = (Solution) obj;
        return ((answer.equals(guest.getAnswer()))
        );
    }
}

