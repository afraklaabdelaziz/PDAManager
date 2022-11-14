package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.Demande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DemandeRepoditoryImpl {
    EntityManager entityManager;
    public List<Demande> findDemandeByIdRespo(Long idResponsable){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select d from Demande d where d.responsable.id = :resp");
        query.setParameter("resp",idResponsable);
        return query.getResultList();
    }
}