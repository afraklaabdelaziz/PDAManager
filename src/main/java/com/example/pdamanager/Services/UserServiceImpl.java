package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.User;
import com.example.pdamanager.Repositories.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl <T> implements InterfaceService<T> {
    UseDaoImpl userDao=new UseDaoImpl();
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public void Add( T t) {
        userDao.add(t);
    }

    @Override
    public void update(T t) {
        userDao.update(t);
    }




    public T findUserByEmail(String email) {
        return (T) userRepository.findByEmail(email);
    }

    @Override
    public List<T> getAll() {
        return userDao.getAll();
    }

}
