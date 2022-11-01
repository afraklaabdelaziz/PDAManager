package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.User;
import com.example.pdamanager.Repositories.UserRepositoryImpl;

public class UserServiceImpl <T> implements InterfaceService<T> {
    UseDaoImpl userDao=new UseDaoImpl();
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public void AddUser( T t) {
        userDao.addUSer(t);
    }

    @Override
    public T findUserByEmail(String email) {
        return (T) userRepository.findByEmail(email);
    }

}
