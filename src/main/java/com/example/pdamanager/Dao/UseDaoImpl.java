package com.example.pdamanager.Dao;
import java.util.List;

import com.example.pdamanager.Entities.User;
import jakarta.persistence.*;



public class UseDaoImpl<T>  implements InterfaceDao <T> {
   private EntityManager em;
    @Override
    public void add(T t) {
         EntityManagerFactory Entity=Persistence.createEntityManagerFactory("PDAManager");
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
    public List list() {
        return null;
    }

    @Override
    public void update(T t) {

        em.getTransaction().begin();
        try{
            em.merge(t);
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
    public T find(Long id) {
        em.getTransaction().begin();
        User user = new User();
        try {
           user= em.find(User.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        } finally {
            em.close();
        }
        return (T) user;
    }
    }
