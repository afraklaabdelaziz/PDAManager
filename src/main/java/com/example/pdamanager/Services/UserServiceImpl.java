package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.User;
import com.example.pdamanager.Repositories.UserRepositoryImpl;

public class UserServiceImpl implements InterfaceService<User>{
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }
}
