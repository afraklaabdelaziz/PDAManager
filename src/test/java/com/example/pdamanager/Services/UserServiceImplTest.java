package com.example.pdamanager.Services;


import com.example.pdamanager.Entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    UserServiceImpl userService = new UserServiceImpl();

    @Test
    void add() {
        User user = new User();
        user.setNom("Afrakla");
        userService.Add(user);
        assertInstanceOf(User.class,user);
    }

    @Test
    void update() {
        User user = (User) userService.findByID(3L);
        user.setNom("Abdelaziz");
        userService.update(user);
        assertInstanceOf(User.class,user);
    }

    @Test
    void findUserByEmail() {
        assertInstanceOf(User.class,userService.findUserByEmail("afraklaabdelaziz@gmail.com"));
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<User>().getClass(),userService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(User.class,userService.findByID(1L));
    }
}