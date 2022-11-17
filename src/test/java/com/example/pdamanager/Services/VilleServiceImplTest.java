package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Ville;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VilleServiceImplTest {

    VilleServiceImpl villeService = new VilleServiceImpl();

    @Test
    void add() {
        Ville ville = new Ville();
        ville.setNom("Zagora");
        villeService.Add(ville);
        assertInstanceOf(Ville.class,ville);
    }

    @Test
    void update() {
        Ville ville = villeService.findByID(3L);
        ville.setNom("Youssoufia");
        villeService.update(ville);
        assertInstanceOf(Ville.class,ville);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Ville>().getClass(),villeService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Ville.class,villeService.findByID(1L));
    }
}