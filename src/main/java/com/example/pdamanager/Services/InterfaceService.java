package com.example.pdamanager.Services;

public interface InterfaceService <T> {
    public void AddUser(T t);
    public T findUserByEmail(String email);
}
