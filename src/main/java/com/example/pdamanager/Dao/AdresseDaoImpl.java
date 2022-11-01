package com.example.pdamanager.Dao;

import com.example.pdamanager.Entities.Adresse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AdresseDaoImpl<T> implements  InterfaceDao<T> {
    private EntityManager em;
    @Override
    public void add(T t) {
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(t);
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
    public  void addVille(T t){
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(t);
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
    public void addPays(T t){
        EntityManagerFactory Entity= Persistence.createEntityManagerFactory("PDAManager");
        em=Entity.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(t);
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
    public List<T> list() {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public T find(Long id) {
        return null;
    }
}
