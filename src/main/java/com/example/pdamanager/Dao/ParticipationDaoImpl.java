package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Participation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
        return null;
    }

    @Override
    public void update(Participation participation) {

    }

    @Override
    public Participation findById(Long id) {
        return null;
    }
}
