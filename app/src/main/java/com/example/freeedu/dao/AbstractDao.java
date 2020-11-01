package com.example.freeedu.dao;

import com.example.freeedu.presenters.BasePresenter;

import java.util.List;

public abstract class AbstractDao implements NotifiedDao {

    BasePresenter presenter;

    public AbstractDao(BasePresenter presenter) {
        this.presenter = presenter;
    }

    abstract public <T> List<T> getAll(String json);

    abstract public <T> T getEntity(String json);

    abstract public void sendRequest();

    public <T> void onSuccess(String data) {
        try {
            List<T> listData = getAll(data);
            presenter.updateModel(listData);
        } catch (Exception e) {

            try {
                T entity = getEntity(data);
                presenter.updateModel(entity);

            } catch (Exception ex) {

            }
        }
    }

    public void onError(String errorMessage) {

        presenter.error(errorMessage);
    }


}
