package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Demande;
import com.example.pdamanager.Entities.StatutDemande;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DemandeServiceImplTest {

    DemandeServiceImpl demandeService = new DemandeServiceImpl();

    @Test
    void add() {
        Demande demande = new Demande();
        demande.setMessage("demande");
        demandeService.Add(demande);
        assertInstanceOf(Demande.class,demande);
    }

    @Test
    void update() {
        Demande demande = demandeService.findByID(3L);
        demande.setStatutDemande(StatutDemande.Accepte);
        demandeService.update(demande);
        assertInstanceOf(Demande.class,demande);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Demande>().getClass(),demandeService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Demande.class,demandeService.findByID(1L));
    }

    @Test
    void findDemandeByIdRespoPartici() {
    }
}