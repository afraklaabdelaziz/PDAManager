package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class UserServiceImplTest {
    UserServiceImpl userService=new UserServiceImpl();
    @Test
    void add() {
        User user=new User();
        user.setPrenom("raouya");
        user.setNom("El yaagoubi");
        userService.Add(user);
    }
}