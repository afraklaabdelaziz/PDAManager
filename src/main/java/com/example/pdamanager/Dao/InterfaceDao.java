package com.example.pdamanager.Dao;


import java.util.List;

public interface InterfaceDao<T> {
    public void addUSer(T t);
    public List<T> listUsers();
    public void updateUser(T t);
    public T findUser(Long id);
}
