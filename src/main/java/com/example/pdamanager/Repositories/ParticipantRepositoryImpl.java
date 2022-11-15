package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.Genre;
import com.example.pdamanager.Entities.Participant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ParticipantRepositoryImpl {
    EntityManager entityManager;
    public List<Participant> findParticipantById(Long idActivite){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select p from Participant p , Participation pa ,Activité a where pa.participant.id = p.id and pa.activite.id = a.id and a.id = :activ");
        query.setParameter("activ",idActivite);
        return query.getResultList();
    }

    public Participant findParticipantByIDActivete(Long idActivite){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select p from Participant p ,Participation pa where pa.participant.id = p.id and pa.activite.id = :idActivite");
        query.setParameter("idActivite",idActivite);
        return (Participant) query.getSingleResult();
    }
    public Participant findParticipantByGenre( String Genre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("select p from Participant p where p.genre=:genre");
        query.setParameter("genre",Genre);
        return (Participant) query.getResultList();
    }

    public List<Participant> findAllParticipant(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("select p from Participant p,Participation pa where pa.participant.id = p.id");
        return (List<Participant>) query.getResultList();
    }
}
