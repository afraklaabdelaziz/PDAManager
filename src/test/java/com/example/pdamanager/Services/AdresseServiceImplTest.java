package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Adresse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AdresseServiceImplTest {
    @Mock
    InterfaceDao addresDao;
@InjectMocks
    AdresseServiceImpl adresseService = new AdresseServiceImpl();

    @Test
    void add() {
        Adresse adresse = new Adresse();
        adresse.setAdresse("Dr tafrgalt ");
        adresseService.Add(adresse);
      verify(addresDao).add(adresse);
    }

    @Test
    void update() {
       Adresse adresse = new Adresse();
        adresse.setAdresse("Dr tafrgalt mezguita ");
        adresseService.update(adresse);
        verify(addresDao).update(adresse);
    }


}