package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Activité;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActiveteServiceImplTest {

    private ActiveteServiceImpl activeteService = new ActiveteServiceImpl();
    @Test
    void add() {
        Activité activite = new Activité();
        activite.setTitle("AAA");
        activite.setTitle("AAA");
        activite.setTitle("AAA");
        activite.setTitle("AAA");
        activite.setTitle("AAA");
        activeteService.Add(activite);
        Activité activite1 = activeteService.findByID(1);
        assertEquals(2L,activite1.getId());
    }

    @Test
    void update() {
        Activité activité = activeteService.findByID(3L);
        activité.setTitle("CCCZ");
        activeteService.update(activité);
        assertInstanceOf(Activité.class,activité);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Activité>().getClass(),activeteService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Activité.class,activeteService.findByID(1L));
    }
}