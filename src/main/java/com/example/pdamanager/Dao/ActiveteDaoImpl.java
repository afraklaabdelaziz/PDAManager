package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Activité;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ActiveteDaoImpl implements InterfaceDao<Activité>{
    private EntityManager entityManager;
    @Override
    public void add(Activité activité) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(activité);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Activité> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activité a");
        return query.getResultList();
    }

    @Override
    public void update(Activité activité) {

    }

    @Override
    public Activité findById(Long id) {
        return null;
    }
}
