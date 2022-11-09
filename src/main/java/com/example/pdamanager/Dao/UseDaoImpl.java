package com.example.pdamanager.Dao;
import java.util.List;

import com.example.pdamanager.Entities.Role;
import com.example.pdamanager.Entities.User;
import jakarta.persistence.*;



public class UseDaoImpl<T>  implements InterfaceDao <T> {
    EntityManagerFactory Entity = Persistence.createEntityManagerFactory("PDAManager");
    EntityManager em = Entity.createEntityManager();

    @Override
    public void add(T t) {
        EntityManagerFactory Entity = Persistence.createEntityManagerFactory("PDAManager");
        em = Entity.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }


    @Override
    public void update(T t) {

        em.getTransaction().begin();
        try {
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public T findById(Long id) {
        em.getTransaction().begin();
        Role role = new Role();
        try {
            role = em.find(Role.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {

            em.getTransaction().rollback();

            ex.printStackTrace();
        }
        return (T) role;
    }

    @Override
    public List<T> getAll() {
        em.getTransaction().begin();
        List<User> users = em.createQuery("select user from User user", User.class).getResultList();//.stream().map(u->u.getNom()).forEach(System.out::println);
        users.stream().map(u -> u.getNom()).forEach(System.out::println);

        em.getTransaction().commit();
        return (List<T>) users;

    }

}
