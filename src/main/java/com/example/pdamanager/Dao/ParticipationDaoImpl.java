package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Entities.Participation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ParticipationDaoImpl implements InterfaceDao<Participation>{
    EntityManager entityManager;
    @Override
    public void add(Participation participation) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(participation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Participation> getAll() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
            entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select p from Participant p", Participant.class);
            entityManager.getTransaction().commit();
            return query.getResultList();
    }

    @Override
    public void update(Participation participation) {

    }

    @Override
    public Participation findById(Long id) {
        return null;
    }
}
