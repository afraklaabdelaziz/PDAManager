package com.example.pdamanager.Services;

import java.util.List;

public interface InterfaceService <T> {

    public void Add(T t);
    public void update(T t);
    public List<T> getAll();
    public T findByID(long id);

}
