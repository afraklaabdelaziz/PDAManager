package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class UserServiceImplTest {
   ActiveteServiceImpl activeteService=new ActiveteServiceImpl();
    @Test
    void add() {
        Activité activité =new Activité();
        activité.setTitle("titre");
        activeteService.Add(activité);
        Activité activité1=activeteService.findByID(1L);
        assertEquals(1L,activité1.getId());
    }
}