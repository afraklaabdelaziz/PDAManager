package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Participation;
import com.example.pdamanager.Entities.Statut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParticipationServiceImplTest {

    ParticipationServiceImpl participationService = new ParticipationServiceImpl();

    @Test
    void add() {
        Participation participation = new Participation();
       participation.setStatut(Statut.Present);
        participationService.Add(participation);
        assertInstanceOf(Participation.class,participation);
    }

    @Test
    void update() {
        Participation participation = participationService.findByID(3L);
        participation.setStatut(Statut.Abscent);
        participationService.update(participation);
        assertInstanceOf(Participation.class,participation);
    }

    @Test
    void getAll() {
        assertInstanceOf(new ArrayList<Participation>().getClass(),participationService.getAll());
    }

    @Test
    void findByID() {
        assertInstanceOf(Participation.class,participationService.findByID(1L));
    }
}