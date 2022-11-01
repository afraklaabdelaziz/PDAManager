package com.example.pdamanager.Dao;
import java.util.List;

import jakarta.persistence.*;



public class UseDaoImpl<T>  implements InterfaceDao <T> {
   private EntityManager em;
    @Override
    public void addUSer(T t) {
         EntityManagerFactory Entity=Persistence.createEntityManagerFactory("PDAManager");
        System.out.println("1");
          em=Entity.createEntityManager();
        System.out.println("2");
          em.getTransaction().begin();
        try{
          em.persist(t);
          em.getTransaction().commit();
            System.out.println("3");
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
    public List listUsers() {
        return null;
    }

    @Override
    public void updateUser(T o) {

    }

    @Override
    public T findUser(Long id) {
        return null;
    }
}
