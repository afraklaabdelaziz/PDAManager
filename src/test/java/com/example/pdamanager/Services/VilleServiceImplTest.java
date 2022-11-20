package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Ville;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VilleServiceImplTest {
    @Mock
    InterfaceDao villeDao;
    @InjectMocks
    VilleServiceImpl villeService = new VilleServiceImpl();

    @Test
    void add() {
        Ville ville = new Ville();
        ville.setNom("Zagora");
        villeService.Add(ville);
        verify(villeDao).add(ville);
    }

    @Test
    void update() {
        Ville ville = new Ville();
        ville.setNom("Youssoufia");
        villeService.update(ville);
        verify(villeDao).update(ville);
    }


}