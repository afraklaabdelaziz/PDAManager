package com.example.pdamanager.Repositories;


public interface InterfaceRepository<T> {
    public T findByEmail(String email);

}
