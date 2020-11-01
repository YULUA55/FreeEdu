package com.example.freeedu.presenters;

import java.util.List;

public interface BasePresenter<T> {
    void requestFromModel();
    void updateModel(List<T> data);
    void updateModel(T data);
    void updateView();

    void error(String errorMessage);

}
