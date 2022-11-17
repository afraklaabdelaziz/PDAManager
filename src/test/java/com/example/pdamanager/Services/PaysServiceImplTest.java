package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Pays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaysServiceImplTest {

    PaysServiceImpl paysService = new PaysServiceImpl();

    @Test
    void add() {
        Pays pays = new Pays();
        pays.setNom("maroc");
        paysService.Add(pays);
    }

    @Test
    void update() {
        Pays pays = paysService.findByID(3L);
        pays.setNom("France");
        paysService.update(pays);
        assertInstanceOf(Pays.class,pays);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Pays>().getClass(),paysService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Pays.class,paysService.findByID(1L));
    }
}