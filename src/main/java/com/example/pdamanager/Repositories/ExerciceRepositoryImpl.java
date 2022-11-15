package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ExerciceRepositoryImpl {
    EntityManager entityManager;
    public List<Exercice> findExrciceByActivite(Long idActivite){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a.exerciceList from Activité a where a.id = :idActivite");
        query.setParameter("idActivite",idActivite);
       return query.getResultList();
    }
}
