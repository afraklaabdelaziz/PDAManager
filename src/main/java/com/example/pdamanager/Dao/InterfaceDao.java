package com.example.pdamanager.Dao;


import java.util.List;

public interface InterfaceDao<T> {
    public void add(T t);
    public List<T> getAll();
    public void update(T t);
    public T findById(Long id);

}
