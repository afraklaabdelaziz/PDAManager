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
    public List<Participant> findParticipantByGenre(Long idActivite, Genre genre ){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select p from Participant p , Participation pa ,Activité a where pa.participant.id = p.id and pa.activite.id = a.id and a.id = :activ and p.genre=:genre");
        query.setParameter("activ",idActivite);
        query.setParameter("genre",genre);
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
    public List<Participant> findParticipantByGenre( Genre genre){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("select p from Participant p where p.genre=:genre");
        query.setParameter("genre",genre);
        return (List<Participant>) query.getResultList();
    }
}
