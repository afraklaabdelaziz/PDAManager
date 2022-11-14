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
            Entity.close();
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
    public List<T> getAll() {
        return null;
    }

    @Override
    public void update(T t) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(t);
      em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override

    public T findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PDAManager");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Adresse adresse = new Adresse();
        try {
            adresse = em.find(Adresse.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        } finally {
            em.close();
        }
        return (T) adresse;
    }

}
