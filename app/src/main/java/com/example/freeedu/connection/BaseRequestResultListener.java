package com.example.freeedu.connection;

import com.example.freeedu.dao.NotifiedDao;

public class BaseRequestResultListener {

    private NotifiedDao dao;

    public BaseRequestResultListener(NotifiedDao dao) {
        this.dao = dao;
    }

    public NotifiedDao getDao() {
        return dao;
    }

    public void notifyAboutSuccess(String data) {
        dao.onSuccess(data);
    }

    public void notifyAboutError(String errorMessage) {
        dao.onError(errorMessage);
    }
}
