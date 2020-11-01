package com.example.freeedu.dao;

import com.example.freeedu.connection.BaseAsyncTask;
import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.connection.DataRequest;
import com.example.freeedu.entities.Lesson;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Collections;


public class LessonDao extends AbstractDao {
    private Gson gson;
    private BaseRequestResultListener listener;
    private DataRequest.DataRequestBuilder builder;

    public LessonDao(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().registerTypeAdapter(Lesson.class, new LessonSerializer()).create();
        listener = new BaseRequestResultListener(this);
        builder = new DataRequest.DataRequestBuilder();
    }


    public void sendRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        builder.setHeaders(headers);
        BaseAsyncTask baseAsyncTask = new BaseAsyncTask(listener);
        baseAsyncTask.execute(builder.build());

    }

    public void sendRequestFromTeacher() {
        builder.setUrl(DataRequest.urlId.TEACHER_LESSONS).setParams("?teacherId=" + 23893);
        sendRequest();

    }

    public void sendRequestFromCourse() {
        builder.setUrl(DataRequest.urlId.COURSE_LESSONS).setParams("?courseId=" + 23893);

    }

    public void sendRequestFromStudent() {
        builder.setUrl(DataRequest.urlId.STUDENT_LESSONS).setParams("?studentId=" + 23893);

    }

    public Lesson getEntity(String json) {
        Lesson lesson = gson.fromJson(json, Lesson.class);
        return lesson;
    }

    public ArrayList<Lesson> getAll(String json) {
        Lesson[] lessons = gson.fromJson(json, Lesson[].class);
        ArrayList<Lesson> list = new ArrayList();
        Collections.addAll(list, lessons);
        return list;
    }
}
