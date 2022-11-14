package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Role;
import com.example.pdamanager.Entities.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class VilleDaoImpl implements InterfaceDao<Ville>{
    private EntityManager em ;
    @Override
    public void add(Ville ville) {
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(ville);
            em.getTransaction().commit();
        }
        catch (Exception ex){

            em.getTransaction().rollback();

            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<Ville> getAll() {
        return null;
    }

    @Override
    public void update(Ville ville) {
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.merge(ville);
            em.getTransaction().commit();
        }
        catch (Exception ex){

            em.getTransaction().rollback();

            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }

    @Override
    public Ville findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Ville ville = new Ville();
        try {
            ville = em.find(Ville.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        return  ville;
    }
}
