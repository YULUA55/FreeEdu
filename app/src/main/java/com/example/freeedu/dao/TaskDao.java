package com.example.freeedu.dao;

import android.widget.ArrayAdapter;

import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Task;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class TaskDao extends AbstractDao {
    private Gson gson;
    private BaseRequestResultListener listener;

    public TaskDao(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.listener = new BaseRequestResultListener(this);
    }

    @Override
    public void sendRequest() {

    }

    public Task getEntity(String json) {
        Task task = gson.fromJson(json, Task.class);
        return task;
    }

    public ArrayList<Task> getAll(String json) {
        Task[] tasks = gson.fromJson(json, Task[].class);
        ArrayList<Task> list = new ArrayList();
        Collections.addAll(list, tasks);

        return list;
    }

}
