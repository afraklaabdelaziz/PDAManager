package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Exercice;
import com.example.pdamanager.Entities.Participation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ExerciceServiceImplTest {

    ExerciceServiceImpl exerciceService = new ExerciceServiceImpl();

    @Test
    void add() {
        Exercice exercice = new Exercice();
        exercice.setNom("ZZZ");
        exerciceService.Add(exercice);
        assertInstanceOf(Exercice.class,exercice);
    }

    @Test
    void update() {
        Exercice exercice = exerciceService.findByID(3L);
        exercice.setNom("CCCZ");
        exerciceService.update(exercice);
        assertInstanceOf(Exercice.class,exercice);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Exercice>().getClass(),exerciceService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Participation.class,exerciceService.findByID(1L));
    }

    @Test
    void findExrciceByActivite() {
    }
}