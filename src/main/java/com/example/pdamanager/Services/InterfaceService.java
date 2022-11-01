package com.example.pdamanager.Services;

public interface InterfaceService <T> {

    public void Add(T t);
    public void update(T t);

    public void AddUser(T t);
    public T findUserByEmail(String email);

}
