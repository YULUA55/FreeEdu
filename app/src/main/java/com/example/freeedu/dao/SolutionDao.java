package com.example.freeedu.dao;

import com.example.freeedu.connection.BaseAsyncTask;
import com.example.freeedu.connection.BaseRequestResultListener;
import com.example.freeedu.connection.DataRequest;
import com.example.freeedu.entities.Course;
import com.example.freeedu.entities.Solution;
import com.example.freeedu.presenters.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionDao extends AbstractDao {
    private Gson gson;
    private BaseRequestResultListener listener;

    public SolutionDao(BasePresenter presenter) {
        super(presenter);
        gson = new GsonBuilder().setPrettyPrinting().create();
        this.listener = new BaseRequestResultListener(this);
    }

    @Override
    public void sendRequest() {

    }

    public Solution getEntity(String json) {
        Solution lesson = gson.fromJson(json, Solution.class);
        return lesson;
    }

    public ArrayList<Solution> getAll(String json) {
        Solution[] solutions = gson.fromJson(json, Solution[].class);
        ArrayList<Solution> list = new ArrayList();
        Collections.addAll(list, solutions);
        return list;
    }

}
