package com.example.freeedu.dao;

import com.example.freeedu.connection.BaseAsyncTask;
import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.entities.Course;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.freeedu.connection.DataRequest.DataRequestBuilder;
import com.example.freeedu.connection.DataRequest.urlId;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Collections;


public class CourseDаo extends AbstractDao {

    private Gson gson;
    private BaseRequestResultListener listener;

    public CourseDаo(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().setPrettyPrinting().create();
        listener = new BaseRequestResultListener(this);
    }

    public void sendRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        DataRequestBuilder builder = new DataRequestBuilder();
        builder.setUrl(urlId.TEACHER_COURSES).setParams("?teacherId=" + 23893).setHeaders(headers);
        BaseAsyncTask baseAsyncTask = new BaseAsyncTask(listener);
        baseAsyncTask.execute(builder.build());
    }

    public Course getEntity(String json) {
        Course course = gson.fromJson(json, Course.class);
        return course;
    }

    public ArrayList<Course> getAll(String json) {
        Course[] courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> list = new ArrayList();
        Collections.addAll(list, courses);
        return list;
    }
}
