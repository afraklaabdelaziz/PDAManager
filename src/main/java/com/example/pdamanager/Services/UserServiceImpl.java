package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.User;

public class UserServiceImpl <T> implements InterfaceService<T> {
    UseDaoImpl userDao=new UseDaoImpl();

    @Override
    public void Add( T t) {
        userDao.add(t);
    }

    @Override
    public void update(T t) {
        userDao.update(t);
    }
}
