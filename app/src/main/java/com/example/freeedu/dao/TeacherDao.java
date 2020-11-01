package com.example.freeedu.dao;

import com.example.freeedu.connection.BaseAsyncTask;
import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.connection.DataRequest;
import com.example.freeedu.entities.Teacher;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherDao extends AbstractDao {
    private Gson gson;
    private BaseRequestResultListener listener;

    public TeacherDao(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.listener = new BaseRequestResultListener(this);
    }

    @Override
    public void sendRequest() {
        System.out.println("захожу");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        DataRequest.DataRequestBuilder builder = new DataRequest.DataRequestBuilder();
        builder.setUrl(DataRequest.urlId.GET_TEACHER).setParams("?teacherId=" + 16).setHeaders(headers);
        BaseAsyncTask baseAsyncTask = new BaseAsyncTask(listener);
        baseAsyncTask.execute(builder.build());
    }

    public Teacher getEntity(String json) {
        Teacher teacher = gson.fromJson(json, Teacher.class);

        return teacher;
    }

    public List<Teacher> getAll(String json) {
        Teacher[] teachers = gson.fromJson(json, Teacher[].class);
        ArrayList<Teacher> list = new ArrayList();
        Collections.addAll(list, teachers);
        return list;
    }

}
