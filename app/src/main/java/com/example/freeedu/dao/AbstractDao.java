package com.example.freeedu.dao;

public abstract class AbstractDao {

    abstract public <T> T[] getAll(String json);
    abstract public <T> T getEntity(String json);
}
