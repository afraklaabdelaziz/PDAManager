package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PaysDaoImpl implements InterfaceDao<Pays>{
    private EntityManager em;
    @Override
    public void add(Pays pays) {
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(pays);
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
    public List<Pays> getAll() {
        return null;
    }

    @Override
    public void update(Pays pays) {
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.merge(pays);
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
    public Pays findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Pays pays = new Pays();
        try {
            pays = em.find(Pays.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        return pays;
    }
}
