package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ParticipantRepositoryImpl {
    EntityManager entityManager;
    public List<Participant> findParticipantById(Long idActivite , Long idParticipant){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select p from Participant p , Participation pa ,Activité a where pa.participant.id = p.id and pa.activite.id = a.id and a.id = :activ and p.id = :partici ");
        query.setParameter("activ",idActivite);
        query.setParameter("partici",idParticipant);
        return query.getResultList();
    }
}
