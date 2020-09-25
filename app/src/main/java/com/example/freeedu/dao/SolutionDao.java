package com.example.freeedu.dao;

import com.example.freeedu.entities.Solution;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SolutionDao {
    Gson gson;

    public SolutionDao() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public Solution getEntity(String json) {
        Solution lesson = gson.fromJson(json, Solution.class);
        return lesson;
    }

    public Solution[] getAll(String json) {
        Solution[] solutions = gson.fromJson(json, Solution[].class);
        return solutions;
    }
}
