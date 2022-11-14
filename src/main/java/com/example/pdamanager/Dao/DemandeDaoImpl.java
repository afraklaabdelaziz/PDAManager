package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Demande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DemandeDaoImpl implements InterfaceDao<Demande>{
    private  EntityManager entityManager;
    @Override
    public void add(Demande demande) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(demande);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Demande> getAll() {
        return null;
    }

    @Override
    public void update(Demande demande) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(demande);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Demande findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Demande demande = new Demande();
        try {
            demande = entityManager.find(Demande.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            ex.printStackTrace();
        }
        return demande;
    }
}
