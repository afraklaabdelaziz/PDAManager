package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Adresse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdresseServiceImplTest {

    AdresseServiceImpl adresseService = new AdresseServiceImpl();

    @Test
    void add() {
        Adresse adresse = new Adresse();
        adresse.setId(1);
        adresse.setAdresse("Dr tafrgalt ");
        adresseService.Add(adresse);
        assertInstanceOf(Adresse.class,adresse);
    }

    @Test
    void update() {
       Adresse adresse = (Adresse) adresseService.findByID(8L);
        adresse.setAdresse("Dr tafrgalt mezguita ");
        adresseService.update(adresse);
        assertInstanceOf(Adresse.class,adresse);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Adresse>().getClass(),adresseService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Adresse.class,adresseService.findByID(1L));
    }

}