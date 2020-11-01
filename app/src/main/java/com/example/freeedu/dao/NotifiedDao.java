package com.example.freeedu.dao;

import java.util.List;

public interface NotifiedDao {

    <T> void onSuccess(String data);

    void onError(String errorMessage);
}
