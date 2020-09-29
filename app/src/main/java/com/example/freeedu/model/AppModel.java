package com.example.freeedu.model;

import com.example.freeedu.entities.Teacher;

public class AppModel {
    private static AppModel instance;
    private String userId;

    private AppModel(String userId) {
        this.userId = userId;
    }

    public static AppModel getInstance() {
        if (instance == null) {
            instance = new AppModel("Ирина");
        }
        return instance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

