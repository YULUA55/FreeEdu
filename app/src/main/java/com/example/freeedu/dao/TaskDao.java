package com.example.freeedu.dao;

import com.example.freeedu.entities.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskDao extends AbstractDao{
    Gson gson;

    public TaskDao() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Task getEntity(String json) {
        Task task = gson.fromJson(json, Task.class);
        return task;
    }

    public Task[] getAll(String json) {
        Task[] tasks = gson.fromJson(json, Task[].class);

        return tasks;
    }
}
