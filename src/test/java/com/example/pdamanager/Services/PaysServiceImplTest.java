package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Pays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class PaysServiceImplTest {
    @Mock
    InterfaceDao paysDao;
    @InjectMocks
    PaysServiceImpl paysService = new PaysServiceImpl();
    @Test
    void add() {
        Pays pays = new Pays();
        pays.setNom("maroc");
        paysService.Add(pays);
        verify(paysDao).add(pays);
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