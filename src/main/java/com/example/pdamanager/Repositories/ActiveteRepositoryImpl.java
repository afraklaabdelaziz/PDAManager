package com.example.pdamanager.Repositories;

import com.example.pdamanager.Entities.Activité;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ActiveteRepositoryImpl {
    EntityManager entityManager;

    public Activité findActiviteByResponsblaID(Long idResponsable) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Activité activite = new Activité();
        try {
            Query query = entityManager.createQuery("select a from Activité a where a.responsable.id = :resp");
            query.setParameter("resp",idResponsable);
            activite = (Activité) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {

            entityManager.getTransaction().rollback();

            ex.printStackTrace();
        }
        return activite;
    }
}
