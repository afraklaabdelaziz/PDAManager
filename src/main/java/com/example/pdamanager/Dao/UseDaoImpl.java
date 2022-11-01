package com.example.pdamanager.Dao;
import java.util.List;

import com.example.pdamanager.Entities.User;
import jakarta.persistence.*;
import org.hibernate.sql.Insert;
import sun.security.util.Password;

public class UseDaoImpl<T>  implements InterfaceDao <T> {
   private EntityManager em;
    @Override
    public void addUSer(T t) {
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
