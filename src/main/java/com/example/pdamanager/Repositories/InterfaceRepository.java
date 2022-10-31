package com.example.pdamanager.Repositories;


import java.util.List;

public interface InterfaceRepository<T> {
    public void addUSer(T t);
    public List<T> listUsers();
    public void updateUser(T t);
    public T findUser(T t);
    public T findByEmail(T t);
}
