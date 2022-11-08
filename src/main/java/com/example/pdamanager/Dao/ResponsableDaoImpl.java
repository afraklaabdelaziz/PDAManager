package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Responsable;
import com.example.pdamanager.Entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ResponsableDaoImpl  implements InterfaceDao<Responsable> {
    EntityManager em;
    @Override
    public void add(Responsable responsable) {

    }

    @Override
    public List<Responsable> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Responsable> responsables = em.createQuery("select r from Responsable r", Responsable.class).getResultList();
        em.getTransaction().commit();
        return  responsables;
    }

    @Override
    public void update(Responsable responsable) {

    }

    @Override
    public Responsable findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Responsable responsable = new Responsable();
        try {
            responsable = em.find(Responsable.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        } finally {
            em.close();
        }
        return responsable;
    }
}
