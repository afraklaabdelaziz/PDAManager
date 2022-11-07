package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Role;
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
    public void update(Activité activite) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(activite);
        entityManager.getTransaction().commit();
    }

    @Override
    public Activité findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Activité activite = new Activité();
        try {
            activite = entityManager.find(Activité.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return activite;
    }
}
