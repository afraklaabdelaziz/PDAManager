package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ExerciceDaoImpl implements InterfaceDao<Exercice> {
    private EntityManager entityManager;
    @Override
    public void add(Exercice exercice) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(exercice);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Exercice> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Exercice e",Exercice.class);
        return query.getResultList();
    }

    @Override
    public void update(Exercice exercice) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(exercice);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Exercice findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Exercice exercice= new Exercice();
        try {
            exercice = entityManager.find(Exercice.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            ex.printStackTrace();
        }
        return exercice;
    }

}
